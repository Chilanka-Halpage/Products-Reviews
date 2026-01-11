package com.csh.productreviews.products.controller;

import com.csh.productreviews.products.dto.ProductListResponse;
import com.csh.productreviews.products.dto.ProductRequest;
import com.csh.productreviews.products.dto.ProductResponse;
import com.csh.productreviews.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "API for managing products with CRUD operations")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @Operation(summary = "Create a product", description = "Create a product")
    public ResponseEntity<String> createProduct(ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Operation(summary = "Update a product", description = "Update a product")
    public ResponseEntity<String> updateProduct(ProductRequest productRequest) {
        productService.updateProduct(productRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Delete a product")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Get all products")
    public ResponseEntity<List<ProductListResponse>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Create a product by ID", description = "Create a product by ID")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

}
