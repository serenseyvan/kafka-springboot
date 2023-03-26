package com.java.assesment.springbootkafka.controller;

import com.java.assesment.springbootkafka.dto.User;
import com.java.assesment.springbootkafka.service.KafkaJsonProducer;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kafka/usermessage")
public class UserMessageController {

    private KafkaJsonProducer kafkaJsonProducer;

    public UserMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaJsonProducer.sendUserMessage(user);
        return ResponseEntity.ok("User json message sent to the kafka topic");

    }
}
