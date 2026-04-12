package com.stockanalyzer.ingestion.controller;

import com.stockanalyzer.ingestion.model.StockResponse;
import com.stockanalyzer.ingestion.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/analyze")
    public StockResponse analyze(@RequestParam String stock) {
        return stockService.analyze(stock);
    }
}
