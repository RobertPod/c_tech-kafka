package com.ctech.consumer2.engine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "weather";

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    public void sendMessage(byte [] message) {
        logger.info(String.format("#### -> Producing serialized message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}