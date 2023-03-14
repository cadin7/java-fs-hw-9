package com.cadincloud.controller;

import com.cadincloud.model.api.CollectionResponse;
import com.cadincloud.model.api.PageInfo;
import com.cadincloud.model.api.Room;
import com.cadincloud.model.api.RoomFilters;
import com.cadincloud.model.mapper.RoomMapper;
import com.cadincloud.service.RoomService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
public class RoomController {

    private final RoomMapper mapper;
    private final RoomService service;

    @GetMapping
    CollectionResponse<Room> getRooms(RoomFilters filters, Pageable pageable) {
        final var rooms = service.getRooms(filters, pageable);
        return new CollectionResponse<>(
                mapper.toApi(rooms.getContent()),
                new PageInfo(
                        rooms.getTotalPages(),
                        rooms.getTotalElements(),
                        pageable.getPageNumber(),
                        pageable.getPageSize()));
    }

    @GetMapping("{roomId}")
    Room getRoom(@PathVariable String roomId) {
        return mapper.toApi(
                service.getRoom(roomId));
    }

    @PatchMapping("{roomId}")
    Room patchRoom(@PathVariable String roomId, @RequestBody JsonPatch patch) {
        return mapper.toApi(
                service.patchRoom(roomId, patch));
    }

    @DeleteMapping("{roomId}")
    Room deleteRoom(@PathVariable String roomId) {
        return mapper.toApi(
                service.deleteRoom(roomId));
    }

}
