package com.order.orderservice.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.order.orderservice.service.VetService;

public class VetControllerTest {
	static VetController vetController;
	static VetService vetService;

	@BeforeClass
	public static void runOnceBeforeClass() throws Exception {
		vetService = new VetService();
		vetController = new VetController(vetService);

	}

	@Test
	public void findAll() throws Exception {

		List<String> list = vetController.listVets();
		System.out.println(list);
		assertTrue(list.size() > 0);

	}

}
