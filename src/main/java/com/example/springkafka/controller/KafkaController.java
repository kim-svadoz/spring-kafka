package com.example.springkafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springkafka.service.KafkaProducer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);

        return "success";
    }
}
