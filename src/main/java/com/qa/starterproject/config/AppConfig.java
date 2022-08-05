package com.qa.starterproject.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	public String greeting() {
		return "Hello my friends";
	}

	@Bean
	@Scope
	public String farewell() {
		return "Goodbye my friends";
	}

	@Bean
	public String serverTime() {
		return "Server started at " + LocalTime.now();

	}

}
