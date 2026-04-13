package com.stockanalyzer.ingestion.client;

import com.stockanalyzer.ingestion.dto.AlphaVantageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class StockApiClient {

    private final WebClient webClient;

    public StockApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://www.alphavantage.co")
                .build();
    }

    public AlphaVantageResponse fetchStock(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "GLOBAL_QUOTE")
                        .queryParam("symbol", symbol)
                        .queryParam("apikey", "YOUR_API_KEY")
                        .build())
                .retrieve()
                .bodyToMono(AlphaVantageResponse.class)
                .block();
    }
}