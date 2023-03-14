package com.cadincloud.model.mapper;

import com.cadincloud.model.api.Cleanup;
import com.cadincloud.model.entity.CleanupEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CleanupMapper {
    Cleanup toApi(CleanupEntity roomEntity);

    CleanupEntity toEntity(Cleanup room);

    List<Cleanup> toApi(List<CleanupEntity> roomEntity);
}
