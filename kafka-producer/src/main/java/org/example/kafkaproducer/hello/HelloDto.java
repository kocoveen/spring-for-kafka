package org.example.kafkaproducer.hello;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record HelloDto(
    String name,
    Integer age,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    LocalDate now,
    Address address
) {
    public record Address(String street, String city, String zipCode) { }
}
