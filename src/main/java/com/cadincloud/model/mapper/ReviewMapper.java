package com.cadincloud.model.mapper;

import com.cadincloud.model.api.Review;
import com.cadincloud.model.entity.ReviewEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toApi(ReviewEntity roomEntity);

    ReviewEntity toEntity(Review room);

    List<Review> toApi(List<ReviewEntity> roomEntity);
}
