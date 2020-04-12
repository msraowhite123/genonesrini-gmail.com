package com.order.orderservice.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class HomeControllerTest {

	@InjectMocks
	private HomeController orderController = new HomeController();

	private MockMvc mockMvc;

	@Mock
	com.order.orderservice.service.OrderService OrderService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

	}

	@Test
	public void getAllOrder200() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/v1/orders"));
		resultActions.andExpect(status().is(200));
	}

	@Test
	public void getAllOrderAssert() throws Exception {
		Mockito.when(OrderService.getOrders()).thenReturn("orderList");
		ResultActions resultActions = mockMvc.perform(get("/api/v1/orders"));
		MvcResult result = resultActions.andExpect(status().is(200)).andReturn();
		assertEquals("orderList", result.getResponse().getContentAsString());
	}

}
