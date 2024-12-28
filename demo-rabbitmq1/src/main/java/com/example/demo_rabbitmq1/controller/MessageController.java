package com.example.demo_rabbitmq1.controller;

import com.example.demo_rabbitmq1.producerP.RabbitMQProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping ("/publish")
    public String sendMessage(@RequestParam String message) {
        rabbitMQProducer.sendMessage(message);
        return "Message sent to RabbitMQ successfully: " + message;
    }
}
