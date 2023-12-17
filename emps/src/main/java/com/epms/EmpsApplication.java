package com.epms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.*",
		"ExceptionHandlers"
})
public class EmpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpsApplication.class, args);
	}

}
