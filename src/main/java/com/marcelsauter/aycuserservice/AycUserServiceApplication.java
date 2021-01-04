package com.marcelsauter.aycuserservice;

import com.ayc.keycloaksecurity.config.EnableKeycloakSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKeycloakSecurity
public class AycUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AycUserServiceApplication.class, args);
	}

}
