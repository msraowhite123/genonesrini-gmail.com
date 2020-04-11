package com.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@Value("${environment}")
	private String environment;

	@RequestMapping("/env-info")
	public String showConfig() {
		return environment;
	}

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public @ResponseBody Boolean healthCheck() {

		return Boolean.TRUE;
	}

}
