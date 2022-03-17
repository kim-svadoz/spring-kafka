package com.example.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(id = "clip3-id", topics = "clip3")
    public void listen(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "clip3-bytes-id", topics = "clip3-bytes")
    public void listenBytes(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "clip3-request-id", topics = "clip3-request")
    @SendTo
    public String listenReply(String message) {
        System.out.println(message);
        return "Pong Clip3";
    }
}
