package com.java.assesment.springbootkafka.service;

import com.java.assesment.springbootkafka.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.apache.kafka.common.errors.*;

@Service
public class KafkaJsonProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserMessage(User userData){
        Message<User> message = MessageBuilder.withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC, "kafkajsontopic")
                .build();
        kafkaTemplate.send(message);
        try {
            kafkaTemplate.send(message);
            logger.info("User message sent: {}", userData.toString());

        } catch (TimeoutException e) {
            logger.info("Timeout error occured while sending message to Kafka");
        } catch (SerializationException e) {
            logger.info("Serialization error occurred while sending message to Kafka");
        }


    }
}
