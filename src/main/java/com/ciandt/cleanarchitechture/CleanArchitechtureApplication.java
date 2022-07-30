package com.ciandt.cleanarchitechture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CleanArchitechtureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitechtureApplication.class, args);
	}

	@GetMapping("/sayhello")
	public String sayHello(String name) {
		return "Hey, " + name + ", how's everything?";
	}

}
