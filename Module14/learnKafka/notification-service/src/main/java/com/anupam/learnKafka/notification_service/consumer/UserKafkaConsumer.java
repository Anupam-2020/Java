package com.anupam.learnKafka.notification_service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaConsumer {

    @KafkaListener(topics = "user-random-topic")
    public void handleUserRandoTopic(String message) {
        log.info("message received 1 {}", message);
    }

    @KafkaListener(topics = "user-random-topic")
    public void handleUserRandoTopic1(String message) {
        log.info("message received 2 {}", message);
    }

    @KafkaListener(topics = "user-random-topic")
    public void handleUserRandoTopic2(String message) {
        log.info("message received 3 {}", message);
    }
}
