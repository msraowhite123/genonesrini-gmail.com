package com.order.orderservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.order.orderservice.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
