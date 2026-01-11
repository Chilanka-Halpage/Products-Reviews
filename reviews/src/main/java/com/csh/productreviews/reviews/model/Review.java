package com.csh.productreviews.reviews.model;

import lombok.Data;

@Data
public class Review {
    private String productId;
    private String reviewContent;
    private int rating;
}
