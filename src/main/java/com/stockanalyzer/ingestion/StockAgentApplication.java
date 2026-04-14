package com.stockanalyzer.ingestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class StockAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockAgentApplication.class, args);
	}

}
