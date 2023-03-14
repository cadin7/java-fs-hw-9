package com.cadincloud.repository;

import com.cadincloud.model.entity.ReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<ReviewEntity, String> {
    List<ReviewEntity> findAllByRoomId(String roomId);
}
