package com.example.demo;

import com.example.demo.FacebookCrawl.Facebook;
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
		Facebook fb = new Facebook();
		fb.normalLogin("s2hdpks22@gmail.com", "Nividiagtx1080");

		return "Hello world";
	}
}
