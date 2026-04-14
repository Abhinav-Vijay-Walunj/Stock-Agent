package com.stockanalyzer.ingestion.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StockProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStock(String message) {
        kafkaTemplate.send("stock-topic", message);
    }
}