package com.krishantha.rentcloud.profileservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String save() {
		return "customer";
	}

}
