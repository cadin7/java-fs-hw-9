package com.cadincloud.model.mapper;

import com.cadincloud.model.api.Room;
import com.cadincloud.model.entity.RoomEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toApi(RoomEntity roomEntity);

    List<Room> toApi(List<RoomEntity> roomEntity);

}
