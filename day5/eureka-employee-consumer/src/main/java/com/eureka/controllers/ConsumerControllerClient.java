package com.eureka.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eureka.services.RemoteCallService;
@RestController
public class ConsumerControllerClient {
	
	
	  @Autowired private DiscoveryClient discoveryClient;
	 
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RemoteCallService remoteCallService;
	
	@RequestMapping(value = "/getemployee", method = RequestMethod.GET)
	public String getEmployee() throws RestClientException, IOException {
		
		/*
		 * List<ServiceInstance>
		 * instances=discoveryClient.getInstances("employee-producer"); ServiceInstance
		 * serviceInstance=instances.get(0);
		 */		
		ServiceInstance serviceInstance=loadBalancer.choose("employee-producer");
		
		String baseUrl=serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/employee";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return response.getBody();
	}
	
	@RequestMapping(value = "/getHystrix", method = RequestMethod.GET)
	public String getHystrix() throws RestClientException, IOException {
		try {
			String emp = remoteCallService.getHystrix();
			System.out.println(emp);
			return emp.toString();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	@RequestMapping(value = "/getEmp", method = RequestMethod.GET)
	public Employee getEmp() throws RestClientException, IOException {
		try {
			Employee emp = remoteCallService.firstPage();
			System.out.println(emp);
			return emp;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	
	@RequestMapping(value = "/getZuleEmployee", method = RequestMethod.GET)
	public String getZuleEmployee() throws RestClientException, IOException {

		List<ServiceInstance> instances = discoveryClient.getInstances("EMPLOYEE-ZUUL-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/producer/employee";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response.getBody();
	}
	

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}