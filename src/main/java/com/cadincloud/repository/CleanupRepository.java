package com.cadincloud.repository;

import com.cadincloud.model.entity.CleanupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CleanupRepository extends MongoRepository<CleanupEntity, String> {
    List<CleanupEntity> findAllByRoomId(String roomId);
}
