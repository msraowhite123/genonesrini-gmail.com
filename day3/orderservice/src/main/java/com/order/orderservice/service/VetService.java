package com.order.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VetService {
	
	/*
	 * 
	 * return list of orders
	 */

	public List<String> findAll() {

		List<String> orderlist = new ArrayList<>();
		orderlist.add("order1");
		orderlist.add("order2");
		orderlist.add("order3");

		return orderlist;

	}

}
