package com.order.orderservice.service;

import com.order.orderservice.domain.User;

public interface UserService {

	public User findByEmail(String email);
	
}
