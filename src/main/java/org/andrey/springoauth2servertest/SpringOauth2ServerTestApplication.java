package org.andrey.springoauth2servertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class SpringOauth2ServerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauth2ServerTestApplication.class, args);
	}

}
