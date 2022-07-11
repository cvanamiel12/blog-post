package com.zuitt.wdc044;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//annotation = shortcuts that make long, repetitive code shorter
@RestController //tells Spring boot that this will use endpoints for handling web requests and responses
public class Wdc044Application {

	public static void main(String[] args) {
		SpringApplication.run(Wdc044Application.class, args);
	}

	@GetMapping("/hello")
	//getmapping = determines endpoint
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("Hello %s", name);
	}

	//Activity
	@GetMapping("/hi")
	public String hi (@RequestParam(value = "greet", defaultValue = "user") String name) {
		return "Hi " + name;
	}
}
