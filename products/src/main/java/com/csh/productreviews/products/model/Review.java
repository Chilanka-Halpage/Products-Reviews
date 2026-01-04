package com.csh.productreviews.products.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Review {
    private double rating;
    private String description;
}

