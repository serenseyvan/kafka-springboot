package com.java.assesment.springbootkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "kafkatopic",groupId = "sampleGroup")
    public void consume(String message){
        logger.info("Message received: {}", message);

    }

}
