package com.stockanalyzer.ingestion.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {

    @KafkaListener(topics = "stock-topic", groupId = "stock-group")
    public void consume(String message) {
        System.out.println("🔥 Received from Kafka: " + message);
    }
}
