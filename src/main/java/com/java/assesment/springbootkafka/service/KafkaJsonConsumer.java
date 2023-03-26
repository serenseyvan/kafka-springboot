package com.java.assesment.springbootkafka.service;

import com.java.assesment.springbootkafka.dao.UserRepository;
import com.java.assesment.springbootkafka.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "kafkajsontopic",groupId = "sampleGroup")
    public void consume(User user){
        save(user);
        logger.info("User  message received and saved in database: {}", user.toString());
    }

    public void save(User user) {
         userRepository.save(user);
    }

}
