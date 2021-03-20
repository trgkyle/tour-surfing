package com.example.demo;

import com.example.demo.FacebookCrawl.Facebook;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.openqa.selenium.Cookie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@RestController
public class TourSurfingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourSurfingApplication.class, args);
	}
	@GetMapping
	public String hello(){
		Facebook fb = new Facebook("[{\"name\":\"datr\",\"value\":\"sexVYO1bzCfC-IPyiL7RLgRg\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1679315890000,\"secure\":true,\"httpOnly\":true},{\"name\":\"c_user\",\"value\":\"100004960057193\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1647779906000,\"secure\":true,\"httpOnly\":false},{\"name\":\"spin\",\"value\":\"r.1003486059_b.trunk_t.1616243909_s.1_v.2_\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1616333909000,\"secure\":true,\"httpOnly\":true},{\"name\":\"xs\",\"value\":\"29%3A8iE9V4xxT_mtkg%3A2%3A1616243909%3A10982%3A6337\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1647779906000,\"secure\":true,\"httpOnly\":true},{\"name\":\"fr\",\"value\":\"1QfHtZsqBcqywFJOE.AWXBc29gJUBP4uapa9-MFKBv3yY.BgVeyx.6g.AAA.0.0.BgVezD.AWUx5D9o8Ds\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1624019903000,\"secure\":true,\"httpOnly\":true},{\"name\":\"locale\",\"value\":\"en_US\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1616848691000,\"secure\":true,\"httpOnly\":false},{\"name\":\"wd\",\"value\":\"1200x835\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1616848706000,\"secure\":true,\"httpOnly\":false},{\"name\":\"sb\",\"value\":\"sexVYOZbIGaiFJyOvHaPAPWc\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1679315909000,\"secure\":true,\"httpOnly\":true}]");
//		Facebook fb2 = new Facebook();
//		fb2.normalLogin("s2hdpks22@gmail.com", "dkm01282046434");
		fb.goGroup();

//		Selenium.setCookies(fb.wd,);
		return "Hello world";
	}
}
