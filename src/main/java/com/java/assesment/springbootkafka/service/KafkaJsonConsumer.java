package com.java.assesment.springbootkafka.service;

import com.java.assesment.springbootkafka.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "kafkajsontopic",groupId = "sampleGroup")
    public void consume(User user){
        logger.info("User  message received: {}", user.toString());
    }

}
