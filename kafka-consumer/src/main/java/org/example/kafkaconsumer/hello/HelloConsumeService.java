package org.example.kafkaconsumer.hello;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RequiredArgsConstructor
@Service
public class HelloConsumeService {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "my-topic-json-1", groupId = "json-group", containerFactory = "kafkaListenerContainerJsonFactory")
    public void receiveToJson1(HelloDto message) {
        log.info("Received Message in [my-topic-json-1]: {}",  message);
    }

    @KafkaListener(topics = "my-topic-json-2", groupId = "json-group", containerFactory = "kafkaListenerContainerJsonFactory")
    public void receiveToJson2(HelloDto message) {
        log.info("Received Message in [my-topic-json-2]: {}",  message);
    }

    @KafkaListener(topics = "my-topic-string-1", groupId = "string-group", containerFactory = "kafkaListenerContainerStringFactory")
    public void receiveToStringHello1(String message) throws JsonProcessingException {
        log.info("Received Message: {}",  message);
        HelloDto helloDto = objectMapper.readValue(message, HelloDto.class);
        log.info("Received Message DTO: {}",  helloDto);
    }

    @KafkaListener(topics = "my-topic-string-2", groupId = "string-group", containerFactory = "kafkaListenerContainerStringFactory")
    public void receiveToStringHello2(String message) throws JsonProcessingException {
        log.info("Received Message: {}",  message);
        HelloDto helloDto = objectMapper.readValue(message, HelloDto.class);
        log.info("Received Message DTO: {}",  helloDto);
    }

}
