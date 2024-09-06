package org.example.kafkaproducer;

import java.util.Collections;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicListing;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }


    // @Bean
    // public ApplicationRunner runner(AdminClient adminClient) {
    //     return args -> {
    //         Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
    //         topics.keySet().stream()
    //             .filter(topicName -> !topics.get(topicName).isInternal())
    //             .map(Collections::singleton)
    //             .forEach(adminClient::deleteTopics);
    //     };
    // }
}
