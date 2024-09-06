package org.example.kafkaproducer.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RequiredArgsConstructor
@RestController
@RequestMapping("/hello")
public class HelloProduceController {

    private final HelloProduceService helloProduceService;

    @PostMapping("/to-string")
    public ResponseEntity<?> helloString(@RequestBody HelloDto dto) throws JsonProcessingException {
        log.info("Received request to produce hello topic: {}", dto);

        helloProduceService.sendString("my-topic-string-1", dto);
        helloProduceService.sendString("my-topic-string-2", dto);
        return ResponseEntity.ok().body(new Result<>("성공적으로 전송되었습니다."));
    }

    @PostMapping("/to-json")
    public ResponseEntity<?> helloJson(@RequestBody HelloDto dto) throws JsonProcessingException {
        log.info("Received request to produce hello topic: {}", dto);

        helloProduceService.sendJson("my-topic-json-1", dto);
        helloProduceService.sendJson("my-topic-json-2", dto);
        return ResponseEntity.ok().body(new Result<>("성공적으로 전송되었습니다."));
    }

    @Data
    private static class Result<T> {
        private T data;

        public Result(T data) {
            this.data = data;
        }
    }
}
