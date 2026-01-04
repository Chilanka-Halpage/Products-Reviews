package com.csh.productreviews.products.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductListResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private double rating;
}
