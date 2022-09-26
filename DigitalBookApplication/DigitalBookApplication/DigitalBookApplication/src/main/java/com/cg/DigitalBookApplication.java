package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan
public class DigitalBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookApplication.class, args);
	}

}
