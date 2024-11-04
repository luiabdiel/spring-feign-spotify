package com.example.spring_feign_spotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignSpotifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignSpotifyApplication.class, args);
	}

}
