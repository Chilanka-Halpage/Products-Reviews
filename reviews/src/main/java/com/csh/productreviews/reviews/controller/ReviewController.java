package com.csh.productreviews.reviews.controller;

import com.csh.productreviews.reviews.model.Review;
import com.csh.productreviews.reviews.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Product Review Controller", description = "API for managing product reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "Add Product Review", description = "Add Product Review with ratings")
    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        reviewService.addReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review Added Successfully");
    }
}
