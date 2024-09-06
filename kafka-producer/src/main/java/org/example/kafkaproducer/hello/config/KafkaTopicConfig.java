package org.example.kafkaproducer.hello.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:10000,localhost:10001,localhost:10002");
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics helloTopic() {
        return new KafkaAdmin.NewTopics(
            TopicBuilder.name("my-topic-string-1")
                .partitions(3)
                .replicas(2)
                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60))
                .build(),
            TopicBuilder.name("my-topic-string-2")
                .partitions(3)
                .replicas(2)
                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60))
                .build(),
            TopicBuilder.name("my-topic-json-1")
                .partitions(3)
                .replicas(2)
                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60))
                .build(),
            TopicBuilder.name("my-topic-json-2")
                .partitions(3)
                .replicas(2)
                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60))
                .build()
        );
    }
}

