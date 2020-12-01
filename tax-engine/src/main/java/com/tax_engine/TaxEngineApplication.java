package com.tax_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
@EnableRetry
@SpringBootApplication
public class TaxEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxEngineApplication.class, args);
	}

}
