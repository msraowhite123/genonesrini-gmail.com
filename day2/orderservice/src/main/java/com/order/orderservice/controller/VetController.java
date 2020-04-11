package com.order.orderservice.controller;

import java.util.List;

import com.order.orderservice.service.VetService;

public class VetController {

	private final VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	public List<String> listVets() {
		return vetService.findAll();
	}
}
