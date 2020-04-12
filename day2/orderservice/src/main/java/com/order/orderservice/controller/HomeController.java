/**
 * 
 */
package com.order.orderservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.controller.error.GlobalExceptionHandler;
import com.order.orderservice.model.Employee;
import com.order.orderservice.repository.EmployeeRepository;
import com.order.orderservice.service.OrderService;


/**
 * @author
 *
 */
@RestController
@RequestMapping("/api/v1")
public class HomeController extends GlobalExceptionHandler{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public String getAllOrder() {
		return orderService.getOrders();
	}
	
	@GetMapping("/orderEx")
	public String getAllOrderException() throws Exception {
		System.out.println("exception handling");
    	  int num  =9/0; 
       return "exception";
	}
	@GetMapping("/emps")
	public List<Employee> getAllEmployees(Model model) {
		return employeeRepository.findAll();
	}

	@PostMapping("/saveEmp")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	

}
