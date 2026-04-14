package com.stockanalyzer.ingestion.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockanalyzer.ingestion.model.StockResponse;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public StockProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStock(StockResponse message) {
        try {
            String json = objectMapper.writeValueAsString(message);

            kafkaTemplate.send("stock-topic", json);

            System.out.println("🔥 Sent JSON: " + json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}