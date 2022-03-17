package com.example.springkafka;

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

@SpringBootApplication
public class SpringKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(AdminClient adminClient) {
        return args -> {
            Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
            for (String topicName : topics.keySet()) {
                // 토픽의 이름을 가져온다
                TopicListing topicListing = topics.get(topicName);
                System.out.println(topicListing);

                // 토픽의 이름뿐만 아니라 모든 정보를 가져온다
                Map<String, TopicDescription> description = adminClient.describeTopics(Collections.singleton(topicName))
                                                                                     .all()
                                                                                     .get();
                System.out.println(description);

                // 토픽의 삭제
                // consumer.offset은 오프셋을 관리하는 중요한 토픽이기 때문에 해당 조건을 추가해 인터널이 아닐 경우만 삭제하도록 설정하는 것이 좋다.
                if (!topicListing.isInternal()) {
                    adminClient.deleteTopics(Collections.singleton(topicName));
                }
            }
        };
    }
}
