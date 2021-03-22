package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TourSurfingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourSurfingApplication.class, args);
	}
	@GetMapping
	public String hello(){
		return "Hệ thống thu thập tour du lịch";
	}
}
