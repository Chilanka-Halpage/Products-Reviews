package com.csh.productreviews.products.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Review {
    @Id
    private String id;
    private String productId;
    private String reviewContent;
    private int rating;
}
