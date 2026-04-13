package com.stockanalyzer.ingestion.service;

import com.stockanalyzer.ingestion.client.StockApiClient;
import com.stockanalyzer.ingestion.model.StockResponse;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockApiClient client;

    public StockService(StockApiClient client) {
        this.client = client;
    }

    public String getStock(String symbol) {
        return client.fetchStock(symbol);
    }
}
