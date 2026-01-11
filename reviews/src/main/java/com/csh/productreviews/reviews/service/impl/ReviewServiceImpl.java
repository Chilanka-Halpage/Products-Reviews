package com.csh.productreviews.reviews.service.impl;

import com.csh.productreviews.reviews.model.Review;
import com.csh.productreviews.reviews.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Override
    public void addReview(Review review) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, review);
    }
}
