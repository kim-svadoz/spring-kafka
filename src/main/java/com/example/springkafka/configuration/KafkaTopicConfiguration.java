package com.example.springkafka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public KafkaAdmin.NewTopics clip3s() {
        return new KafkaAdmin.NewTopics(

        );
    }
}
