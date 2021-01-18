package com.p_015;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class DigMedArchiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigMedArchiveApplication.class, args);
	}

}
