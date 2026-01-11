package com.csh.productreviews.products.service;

import com.csh.productreviews.products.dto.ProductListResponse;
import com.csh.productreviews.products.dto.ProductRequest;
import com.csh.productreviews.products.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
    void updateProduct(ProductRequest productRequest);
    void deleteProduct(String id);
    List<ProductListResponse> getAllProducts();
    ProductResponse getProductById(String id);
    void updateProductRating(String productId, double rating);
}
