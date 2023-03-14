package com.cadincloud.repository.dao;

import com.cadincloud.model.api.RoomFilters;
import com.cadincloud.model.entity.RoomEntity;
import com.cadincloud.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class RoomDao {

    private final MongoTemplate mongo;
    private final RoomRepository repository;

    public Page<RoomEntity> findRooms(RoomFilters filters, Pageable pageable) {
        final var criteria = new Criteria();

        buildFilters(filters, criteria);

        final var query = Query.query(criteria).with(pageable);

        final var rooms = mongo.find(query, RoomEntity.class);

        return PageableExecutionUtils.getPage(
                rooms,
                pageable,
                () -> mongo.count(
                        query.limit(-1).skip(-1),
                        RoomEntity.class));
    }

    public Optional<RoomEntity> findRoom(String roomId) {
        return repository.findById(roomId);
    }

    public void deleteRoom(String roomId) {
        repository.deleteById(roomId);
    }

    public RoomEntity saveRoom(RoomEntity room) {
        return repository.save(room);
    }

    private void buildFilters(RoomFilters filters, Criteria criteria) {
        ofNullable(filters.number())
                .ifPresent(number -> criteria.and("number").is(number));
        ofNullable(filters.floor())
                .ifPresent(floor -> criteria.and("floor").is(floor));
        ofNullable(filters.hotelName())
                .ifPresent(hotelName -> criteria.and("hotelName").is(hotelName));
        ofNullable(filters.tv())
                .ifPresent(tv -> criteria.and("facilities.tv").is(tv));
        ofNullable(filters.doubleBed())
                .ifPresent(doubleBed -> criteria.and("facilities.doubleBed").is(doubleBed));
    }
}
