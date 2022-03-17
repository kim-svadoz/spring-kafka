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
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import com.example.springkafka.producer.KafkaProducer;

@SpringBootApplication
public class SpringKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaProducer kafkaProducer,
                                    KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer) {
        return args -> {
            kafkaProducer.aysnc("clip4", "Hello, Clip4 Container");
            kafkaMessageListenerContainer.start();
            Thread.sleep(1_000L);

            System.out.println("====== pause ======");
            kafkaMessageListenerContainer.pause();
            Thread.sleep(5_000L);
            kafkaProducer.aysnc("clip4", "Hello, Secondly Clip4 Container");

            System.out.println("====== resume ======");
            kafkaMessageListenerContainer.resume();
            Thread.sleep(1_000L);

            System.out.println("====== stop ======");
            kafkaMessageListenerContainer.stop();
        };
    }
}
