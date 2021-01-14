package com.marcelsauter.aycuserservice;

import com.ayc.keycloaksecurity.config.EnableKeycloakSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableKeycloakSecurity
@EnableMongoRepositories
public class AycUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AycUserServiceApplication.class, args);
	}

}
