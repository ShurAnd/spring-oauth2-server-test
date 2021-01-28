package org.andrey.springoauth2servertest.controller;

import java.security.Principal;
import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	
	@GetMapping
	public String test(Principal principal) {
		
		String authorizationValue = Base64.getEncoder().encodeToString("admin:admin".getBytes());
		
		return authorizationValue;
	}
	
}
