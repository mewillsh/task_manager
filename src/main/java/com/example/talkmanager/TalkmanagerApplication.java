package com.example.talkmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TalkmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalkmanagerApplication.class, args);
	}

}
