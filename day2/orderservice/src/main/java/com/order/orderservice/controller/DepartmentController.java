package com.order.orderservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.order.orderservice.model.Department;
import com.order.orderservice.repository.DepartmentRepository;

@Controller
@RequestMapping("/api/v1")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/department")
	public String getAllEmployees(Model model) {
		model.addAttribute("message", "List Of Employees");
		model.addAttribute("tasks", departmentRepository.findAll());
		return "view";
	}

	@PostMapping("/department")
	public String createEmployee(@Valid @RequestBody Department employee) {
		departmentRepository.save(employee);
		return "success";
	}
}
