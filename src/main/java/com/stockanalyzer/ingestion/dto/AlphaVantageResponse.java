package com.stockanalyzer.ingestion.dto;

public class AlphaVantageResponse {
    private GlobalQuote globalQuote;

    public GlobalQuote getGlobalQuote() {
        return globalQuote;
    }

    public void setGlobalQuote(GlobalQuote globalQuote) {
        this.globalQuote = globalQuote;
    }

    public static class GlobalQuote {
        private String symbol;
        private String price;
        private String change;
        private String changePercent;
    }
}