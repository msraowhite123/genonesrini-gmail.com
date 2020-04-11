package com.order.orderservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.order.orderservice.model.Employee;
import com.order.orderservice.repository.EmployeeRepository;

@Controller
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		model.addAttribute("message", "List Of Employees");
		model.addAttribute("tasks", employeeRepository.findAll());
		return "view";
	}

	@PostMapping("/employees")
	public String createEmployee(@Valid @RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "success";
	}
}
