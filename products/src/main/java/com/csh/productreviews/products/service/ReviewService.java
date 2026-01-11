package com.csh.productreviews.products.service;

import com.csh.productreviews.products.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsByProductId(String id);
}

