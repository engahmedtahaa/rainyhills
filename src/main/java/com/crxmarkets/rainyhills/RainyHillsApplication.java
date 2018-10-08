package com.crxmarkets.rainyhills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author AhmedTaha
 * This the spring boot application starter class 
 */
@SpringBootApplication
@ComponentScan
public class RainyHillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RainyHillsApplication.class, args);
	}
}
