package org.example.kafkaproducer.hello;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RequiredArgsConstructor
@Service
public class HelloProduceService {

    private final KafkaTemplate<String, String> kafkaStringTemplate;
    private final KafkaTemplate<String, Object> kafkaJsonTemplate;
    private final ObjectMapper objectMapper;

    public void sendString(String topic, HelloDto message) throws JsonProcessingException {
        String jsonMessage = objectMapper.writeValueAsString(message);
        log.info("Sending message: {} in {}", jsonMessage, topic);
        kafkaStringTemplate.send(topic, jsonMessage);
    }

    public void sendJson(String topic, HelloDto jsonMessage) {
        log.info("Sending message: {} in {}", jsonMessage, topic);
        kafkaJsonTemplate.send(topic, jsonMessage);
    }
}
