package com.stockanalyzer.ingestion.service;

import com.stockanalyzer.ingestion.client.StockApiClient;
import com.stockanalyzer.ingestion.dto.AlphaVantageResponse;
import com.stockanalyzer.ingestion.kafka.StockProducer;
import com.stockanalyzer.ingestion.model.StockResponse;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockApiClient client;
    private final StockProducer producer;

    public StockService(StockApiClient client, StockProducer producer) {
        this.client = client;
        this.producer = producer;
    }

    public StockResponse getStock(String symbol) {
        AlphaVantageResponse response = client.fetchStock(symbol);

        AlphaVantageResponse.GlobalQuote quote = response.getGlobalQuote();

        StockResponse stock = new StockResponse(
                quote.getSymbol(),
                Double.parseDouble(quote.getPrice()),
                Double.parseDouble(quote.getChange()),
                quote.getChangePercent()
        );
        producer.sendStock(stock.toString());

        return stock;
    }
}
