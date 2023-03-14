package com.cadincloud.repository.dao;

import com.cadincloud.model.entity.ReviewEntity;
import com.cadincloud.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReviewDao {

    private final ReviewRepository repository;

    public List<ReviewEntity> findReviews(String roomId) {
        return repository.findAllByRoomId(roomId);
    }

    public ReviewEntity saveReview(ReviewEntity review) {
        return repository.save(review);
    }

    public Optional<ReviewEntity> findReview(String reviewId) {
        return repository.findById(reviewId);
    }

    public void deleteReview(String reviewId) {
        repository.deleteById(reviewId);
    }
}
