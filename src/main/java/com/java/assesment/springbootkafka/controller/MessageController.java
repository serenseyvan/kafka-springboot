package com.java.assesment.springbootkafka.controller;

import com.java.assesment.springbootkafka.service.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka/message")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
         kafkaProducer.sendMessage(message);
         return ResponseEntity.ok("Message sent to the kafka topic");
    }
}
