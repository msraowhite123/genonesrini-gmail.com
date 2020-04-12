package com.order.orderservice.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.order.orderservice.model.EmployeeCurdOperation;
import com.order.orderservice.repository.EmployeeCurdRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EmployeeControllerMVCTest {

	@InjectMocks
	private EmployeeControllerIntegration employeeControllerIntegration = new EmployeeControllerIntegration();

	private MockMvc mockMvc;

	@Mock
	EmployeeCurdRepository employeeRepository;
	
	@Mock
	EmployeeCurdOperation employeeCurdOperation;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeControllerIntegration).build();

	}

	
	@Test
	public void saveEmp() throws Exception {
		
		EmployeeCurdOperation employee = new EmployeeCurdOperation();
		employee.setEmailId("admin@gmail.com");
		employee.setFirstName("admin");
		employee.setLastName("admin");

		
		Mockito.when(employeeRepository.save(employeeCurdOperation)).thenReturn(employee);

		String eda = "{\"id\":0,\"firstName\":\"admin\",\"lastName\":\"admin\",\"emailId\":\"admin@test.com\"}\n"
				+ "";
		String response = mockMvc.perform(post("/api/v1/employees").content(eda).header(HttpHeaders.CONTENT_TYPE,
				MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertNotNull(response);
	}
}
