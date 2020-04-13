package com.eureka.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eureka.controllers.Employee;



@FeignClient(name="employee-producer")
public interface RemoteCallService {
	@RequestMapping(method=RequestMethod.GET, value="/getHystrix")
	public String getHystrix();
	
	@RequestMapping(method=RequestMethod.GET, value="/employee")
	public Employee firstPage();

}