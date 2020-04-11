/**
 * 
 */
package com.order.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 *
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@GetMapping("/orders")
	public String getAllOrder() {
		return "orders test";
	}

}
