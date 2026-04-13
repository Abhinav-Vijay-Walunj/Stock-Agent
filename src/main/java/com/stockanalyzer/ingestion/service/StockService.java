package com.stockanalyzer.ingestion.service;

import com.stockanalyzer.ingestion.client.StockApiClient;
import com.stockanalyzer.ingestion.dto.AlphaVantageResponse;
import com.stockanalyzer.ingestion.model.StockResponse;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockApiClient client;

    public StockService(StockApiClient client) {
        this.client = client;
    }

    public StockResponse getStock(String symbol) {
        AlphaVantageResponse response = client.fetchStock(symbol);

        AlphaVantageResponse.GlobalQuote quote = response.getGlobalQuote();

        return new StockResponse(
                quote.getSymbol(),
                Double.parseDouble(quote.getPrice()),
                Double.parseDouble(quote.getChange()),
                quote.getChangePercent()
        );
    }
}
