package com.cadincloud.service;

import com.cadincloud.exceptions.ResourceNotFoundException;
import com.cadincloud.model.api.RoomFilters;
import com.cadincloud.model.entity.RoomEntity;
import com.cadincloud.repository.dao.RoomDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomDao dao;
    private final ObjectMapper mapper;

    public Page<RoomEntity> getRooms(RoomFilters filters, Pageable pageable) {
        return dao.findRooms(filters, pageable);
    }

    public RoomEntity getRoom(String roomId) {
        return getRoomOrThrow(roomId);
    }

    @SneakyThrows
    public RoomEntity patchRoom(String roomId, JsonPatch patch) {
        final var dbRoom = getRoomOrThrow(roomId);
        final var patchedJson = patch.apply(mapper.valueToTree(dbRoom));
        final var patchedRoomEntity = mapper.treeToValue(patchedJson, RoomEntity.class);

        return replaceRoom(roomId, patchedRoomEntity);
    }

    public RoomEntity deleteRoom(String roomId) {
        final var roomToDelete = getRoomOrThrow(roomId);

        dao.deleteRoom(roomId);

        return roomToDelete;
    }

    private RoomEntity getRoomOrThrow(String roomId) {
        return dao.findRoom(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't found room with id: " + roomId));
    }

    private RoomEntity replaceRoom(String roomId, RoomEntity patchedRoomEntity) {
        patchedRoomEntity.setId(roomId);

        return dao.saveRoom(patchedRoomEntity);
    }
}
