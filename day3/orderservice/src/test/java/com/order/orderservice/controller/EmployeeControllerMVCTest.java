package com.order.orderservice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.orderservice.model.EmployeeCurdOperation;
import com.order.orderservice.repository.EmployeeCurdRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeControllerIntegration.class)
public class EmployeeControllerMVCTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	EmployeeCurdRepository employeeRepository;

	@Before
	public void setUp() {

	}

	@Test
	public void saveEmp() throws Exception {
		EmployeeCurdOperation employee = new EmployeeCurdOperation();
		employee.setEmailId("admin@gmail.com");
		employee.setFirstName("admin");
		employee.setLastName("admin");
		ObjectMapper objectMapper = new ObjectMapper();
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

		String eda = "{\"id\":0,\"firstName\":\"admin\",\"lastName\":\"admin\",\"emailId\":\"admin@test.com\"}\n" + "";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employees").content(eda)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
