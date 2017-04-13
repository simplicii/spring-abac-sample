package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Renato Soppelsa
 * 2017
 */
@SpringBootApplication
@ComponentScan
public class AbacTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(AbacTestApplication.class, args);
	}
}
