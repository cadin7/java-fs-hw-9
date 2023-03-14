package com.cadincloud.service;

import com.cadincloud.exceptions.ResourceNotFoundException;
import com.cadincloud.model.entity.ReviewEntity;
import com.cadincloud.repository.dao.ReviewDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewDao dao;
    private final ObjectMapper mapper;

    public List<ReviewEntity> getReviews(String roomId) {
        return dao.findReviews(roomId);
    }

    public ReviewEntity addReview(ReviewEntity review) {
        return dao.saveReview(review);
    }

    @SneakyThrows
    public ReviewEntity patchReview(String reviewId, JsonPatch patch) {
        final var dbReview = getReviewOrThrow(reviewId);
        final var patchedJson = patch.apply(mapper.valueToTree(dbReview));
        final var patchedReviewEntity = mapper.treeToValue(patchedJson, ReviewEntity.class);

        return replaceReview(reviewId, patchedReviewEntity);
    }

    public ReviewEntity deleteReview(String reviewId) {
        final var reviewToDelete = getReviewOrThrow(reviewId);

        dao.deleteReview(reviewId);

        return reviewToDelete;
    }

    private ReviewEntity getReviewOrThrow(String reviewId) {
        return dao.findReview(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't found review with id: " + reviewId));
    }

    private ReviewEntity replaceReview(String reviewId, ReviewEntity patchedReviewEntity) {
        patchedReviewEntity.setId(reviewId);

        return dao.saveReview(patchedReviewEntity);
    }
}
