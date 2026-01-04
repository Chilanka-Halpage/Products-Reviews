package com.csh.productreviews.products.dto;

import com.csh.productreviews.products.model.Review;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private double rating;
    private List<Review> reviewList;
}
