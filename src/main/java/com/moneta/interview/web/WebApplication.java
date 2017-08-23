package com.moneta.interview.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Application main configuration.
 *
 * @author Petr Juza
 */
@SpringBootApplication(scanBasePackages = "com.moneta.interview")
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
