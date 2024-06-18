package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.gcu"})
@EnableJpaRepositories(basePackages = "com.gcu.data.repository")
public class TestApplication {
	
	/**
	 * Constructs a new TrendyTrunkApplication.
	 * This is the default constructor.
	 */
	public TestApplication() {
	    // Default constructor implementation
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
