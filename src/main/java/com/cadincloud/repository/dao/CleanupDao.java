package com.cadincloud.repository.dao;

import com.cadincloud.model.entity.CleanupEntity;
import com.cadincloud.repository.CleanupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CleanupDao {

    private final CleanupRepository repository;

    public List<CleanupEntity> findAllByRoomId(String roomId) {
        return repository.findAllByRoomId(roomId);
    }

    public CleanupEntity saveCleanup(CleanupEntity cleanup) {
        return repository.save(cleanup);
    }

    public void deleteCleanup(String cleanupId) {
        repository.deleteById(cleanupId);
    }

    public Optional<CleanupEntity> findCleanup(String cleanupId) {
        return repository.findById(cleanupId);
    }
}
