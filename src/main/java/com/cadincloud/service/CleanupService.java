package com.cadincloud.service;

import com.cadincloud.exceptions.ResourceNotFoundException;
import com.cadincloud.model.entity.CleanupEntity;
import com.cadincloud.repository.dao.CleanupDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CleanupService {

    private final CleanupDao dao;
    private final ObjectMapper mapper;

    public List<CleanupEntity> getCleanups(String roomId) {
        return dao.findAllByRoomId(roomId);
    }

    public CleanupEntity addCleanup(CleanupEntity cleanup) {
        return dao.saveCleanup(cleanup);
    }

    @SneakyThrows
    public CleanupEntity patchCleanup(String cleanupId, JsonPatch patch) {
        final var dbReview = getCleanupOrThrow(cleanupId);
        final var patchedJson = patch.apply(mapper.valueToTree(dbReview));
        final var patchedCleanupEntity = mapper.treeToValue(patchedJson, CleanupEntity.class);

        return replaceCleanup(cleanupId, patchedCleanupEntity);
    }

    public CleanupEntity deleteCleanup(String cleanupId) {
        final var cleanupToDelete = getCleanupOrThrow(cleanupId);

        dao.deleteCleanup(cleanupId);

        return cleanupToDelete;
    }

    private CleanupEntity getCleanupOrThrow(String cleanupId) {
        return dao.findCleanup(cleanupId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't found review with id: " + cleanupId));
    }

    private CleanupEntity replaceCleanup(String cleanupId, CleanupEntity patchedCleanupEntity) {
        patchedCleanupEntity.setId(cleanupId);

        return dao.saveCleanup(patchedCleanupEntity);
    }
}
