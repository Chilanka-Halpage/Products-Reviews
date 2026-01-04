package com.csh.productreviews.products.repository;

import com.csh.productreviews.products.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
