package com.therealdanvega;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.order.orderservice.SecurityCustomApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SecurityCustomApplication.class)
@WebAppConfiguration
public class SecurityCustomApplicationTests {

	@Test
	public void contextLoads() {
	}

}
