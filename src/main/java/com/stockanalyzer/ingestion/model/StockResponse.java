package com.stockanalyzer.ingestion.model;

import lombok.Data;

@Data
public class StockResponse {
    private String stock;
    private double price;
    private String sentiment;
    private String recommendation;

    // getters + setters
}
