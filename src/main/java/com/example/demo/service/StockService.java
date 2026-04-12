package com.example.demo.service;

import com.example.demo.model.StockResponse;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    public StockResponse analyze(String stock) {
        StockResponse response = new StockResponse();
        response.setStock(stock);
        response.setPrice(2450);
        response.setSentiment("NEUTRAL");
        response.setRecommendation("HOLD");
        return response;
    }
}
