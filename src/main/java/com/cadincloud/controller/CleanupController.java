package com.cadincloud.controller;

import com.cadincloud.model.api.Cleanup;
import com.cadincloud.model.mapper.CleanupMapper;
import com.cadincloud.service.CleanupService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("room/{roomId}/cleanups")
public class CleanupController {

    private final CleanupMapper mapper;
    private final CleanupService service;

    @GetMapping
    List<Cleanup> getCleanups(@PathVariable String roomId) {
        return mapper.toApi(
                service.getCleanups(roomId));
    }

    @PostMapping
    Cleanup addCleanup(@RequestBody Cleanup cleanup) {
        return mapper.toApi(
                service.addCleanup(
                        mapper.toEntity(cleanup)));
    }

    @PatchMapping("{cleanupId}")
    Cleanup patchCleanup(@PathVariable String cleanupId,
                         @RequestBody JsonPatch patch) {
        return mapper.toApi(
                service.patchCleanup(cleanupId, patch));
    }

    @DeleteMapping("{cleanupId}")
    Cleanup deleteCleanup(@PathVariable String cleanupId) {
        return mapper.toApi(
                service.deleteCleanup(cleanupId));
    }
}
