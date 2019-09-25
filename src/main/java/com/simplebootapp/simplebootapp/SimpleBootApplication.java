package com.simplebootapp.simplebootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.simplebootapp")
public class SimpleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBootApplication.class, args);
	}

}
