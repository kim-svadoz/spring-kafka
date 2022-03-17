package com.example.springkafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class KafkaProducer {
    public static final String TOPIC = "kafka-demo";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println(String.format("Produce Message : %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
