package com.stockanalyzer.ingestion.controller;

import com.stockanalyzer.ingestion.model.StockResponse;
import com.stockanalyzer.ingestion.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/analyze")
    public StockResponse analyze(@RequestParam String stock) {
        return stockService.getStock(stock);
    }
}