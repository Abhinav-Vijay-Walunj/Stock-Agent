package com.stockanalyzer.ingestion.model;

public class StockResponse {

    private String symbol;
    private double price;
    private double change;
    private String changePercent;

    public StockResponse(String symbol, double price, double change, String changePercent) {
        this.symbol = symbol;
        this.price = price;
        this.change = change;
        this.changePercent = changePercent;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public double getChange() { return change; }
    public String getChangePercent() { return changePercent; }
}