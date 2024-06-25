package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan({"com.gcu"})
@EnableJpaRepositories(basePackages = "com.gcu.data.repository")
public class TestApplication {
	// SLF 4 J Logger
	private static final Logger logger = LoggerFactory.getLogger(TestApplication.class);
	
	/**
	 * Constructs a new TrendyTrunkApplication.
	 * This is the default constructor.
	 */
	public TestApplication() {
	    // Default constructor implementation
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		logger.info("Application started successfully.");
	}

}
