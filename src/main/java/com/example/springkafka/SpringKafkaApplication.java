package com.example.springkafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import com.example.springkafka.model.Animal;
import com.example.springkafka.producer.KafkaProducer;

@SpringBootApplication
public class SpringKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaProducer kafkaProducer) {
        return args -> {
            kafkaProducer.async("clip4-animal", new Animal("puppy", 9));
        };
    }
}
