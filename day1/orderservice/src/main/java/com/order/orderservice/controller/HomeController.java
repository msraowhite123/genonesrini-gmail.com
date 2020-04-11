/**
 * 
 */
package com.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.service.OrderService;


/**
 * @author
 *
 */
@RestController
@RequestMapping("/api/v1")
public class HomeController {

	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public String getAllOrder() {
		return orderService.getOrders();
	}

}
