package com.csh.productreviews.products.service.impl;

import com.csh.productreviews.products.model.Review;
import com.csh.productreviews.products.repository.ReviewRepository;
import com.csh.productreviews.products.service.ProductService;
import com.csh.productreviews.products.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(Review review) {
        productService.updateProductRating(review.getProductId(), review.getRating());
        reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByProductId(String id) {
        return reviewRepository.findByProductId(id);
    }
}
