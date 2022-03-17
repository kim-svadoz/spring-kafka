package com.example.springkafka.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public KafkaAdmin.NewTopics clip3s() {
        return new KafkaAdmin.NewTopics(
            TopicBuilder.name("clip3").build(),
            TopicBuilder.name("clip3-bytes").build(),
            TopicBuilder.name("clip3-request").build(),
            TopicBuilder.name("clip3-reply").build()

        );
    }
}
