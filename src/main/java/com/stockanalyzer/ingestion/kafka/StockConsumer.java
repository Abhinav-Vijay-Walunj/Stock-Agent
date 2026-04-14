package com.stockanalyzer.ingestion.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockanalyzer.ingestion.model.StockResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "stock-topic", groupId = "stock-group")
    public void consume(String message) {
        try {
            StockResponse stock = objectMapper.readValue(message, StockResponse.class);
            System.out.println("🔥 Parsed Object: " + stock.getSymbol() + " | Price: " + stock.getPrice());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
