package com.csh.productreviews.products.service.impl;

import com.csh.productreviews.products.dto.ProductListResponse;
import com.csh.productreviews.products.dto.ProductRequest;
import com.csh.productreviews.products.dto.ProductResponse;
import com.csh.productreviews.products.exception.NotFoundException;
import com.csh.productreviews.products.model.Product;
import com.csh.productreviews.products.repository.ProductRepository;
import com.csh.productreviews.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductListResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product ->
                ProductListResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .rating(product.getRating())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product Not Found with Id : " + id));
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .rating(product.getRating())
                .reviewList(List.of())
                .build();
    }
}
