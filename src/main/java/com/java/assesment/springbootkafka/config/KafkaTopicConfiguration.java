package com.java.assesment.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic kafkaTopic(){
        return TopicBuilder.name("kafkatopic").build();

    }

    @Bean
    public NewTopic kafkaJsonTopic(){
        return TopicBuilder.name("kafkajsontopic").build();

    }
}
