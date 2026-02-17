package com.example.moodrecommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(
		exclude = { SecurityAutoConfiguration.class }
)
public class MoodrecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run( MoodrecommendationApplication.class, args);
	}

}
