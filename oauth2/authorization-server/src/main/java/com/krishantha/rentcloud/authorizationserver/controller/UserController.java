package com.krishantha.rentcloud.authorizationserver.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/")
	public String user() {
		return "user";
	}
	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
	}

}
