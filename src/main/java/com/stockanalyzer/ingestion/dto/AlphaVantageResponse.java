package com.stockanalyzer.ingestion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlphaVantageResponse {

    @JsonProperty("Global Quote")   // VERY IMPORTANT
    private GlobalQuote globalQuote;

    public GlobalQuote getGlobalQuote() {
        return globalQuote;
    }

    public void setGlobalQuote(GlobalQuote globalQuote) {
        this.globalQuote = globalQuote;
    }

    public static class GlobalQuote {

        @JsonProperty("01. symbol")
        private String symbol;

        @JsonProperty("05. price")
        private String price;

        @JsonProperty("09. change")
        private String change;

        @JsonProperty("10. change percent")
        private String changePercent;

        // Getters
        public String getSymbol() {
            return symbol;
        }

        public String getPrice() {
            return price;
        }

        public String getChange() {
            return change;
        }

        public String getChangePercent() {
            return changePercent;
        }

        // Setters
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setChange(String change) {
            this.change = change;
        }

        public void setChangePercent(String changePercent) {
            this.changePercent = changePercent;
        }
    }
}