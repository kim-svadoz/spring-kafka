package com.example.springkafka;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.springkafka.producer.KafkaProducer;

@SpringBootApplication
public class SpringKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaProducer kafkaProducer) {
        return args -> {
            kafkaProducer.aysnc("clip3", "Hello, Clip3-async");
            kafkaProducer.sync("clip3", "Hello, CLip3-sync");
            kafkaProducer.routingSend("clip3", "Hello, Clip3-routing");
            kafkaProducer.routingSendBytes("clip3-bytes", "Hello, Clip3-bytes".getBytes(StandardCharsets.UTF_8));
            kafkaProducer.replyingSend("clip3-request", "Ping Clip3 !!");
        };
    }
}
