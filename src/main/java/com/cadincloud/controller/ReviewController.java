package com.cadincloud.controller;

import com.cadincloud.model.api.Review;
import com.cadincloud.model.mapper.ReviewMapper;
import com.cadincloud.service.ReviewService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("room/{roomId}/reviews")
public class ReviewController {

    private final ReviewMapper mapper;
    private final ReviewService service;

    @GetMapping
    List<Review> getReviews(@PathVariable String roomId) {
        return mapper.toApi(
                service.getReviews(roomId));
    }

    @PostMapping
    Review addReview(@RequestBody Review review) {
        return mapper.toApi(
                service.addReview(
                        mapper.toEntity(review)));
    }

    @PatchMapping("{reviewId}")
    Review patchReview(@PathVariable String reviewId,
                       @RequestBody JsonPatch patch) {
        return mapper.toApi(
                service.patchReview(reviewId, patch));
    }

    @DeleteMapping("{reviewId}")
    Review deleteReview(@PathVariable String reviewId) {
        return mapper.toApi(
                service.deleteReview(reviewId));
    }
}
