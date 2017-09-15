package com.own.proj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.own.proj.modelClass.Employee;
import com.own.proj.modelClass.EmployeeAddress;

@RestController //It simply says that it is REST API based controller
public class RestAPIController {
	
	//@ResponseBody //If @RestController is used, @ResponseBody is not required
	@RequestMapping(value="/employeeAddressList", method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE /*It supports only json format*/)
	public List<EmployeeAddress> getEmployeeAddressList() { 
		EmployeeAddress empAddress1 = new EmployeeAddress();
		empAddress1.setCity("Chennai");
		empAddress1.setCountry("India");
		
		EmployeeAddress empAddress2 = new EmployeeAddress();
		empAddress2.setCity("Newyork");
		
		EmployeeAddress empAddress3 = new EmployeeAddress();
		empAddress3.setCity("Pune");
		
		ArrayList<EmployeeAddress> empAddressList = new ArrayList<>();
		empAddressList.add(empAddress1);
		empAddressList.add(empAddress2);
		empAddressList.add(empAddress3);
		return empAddressList;
	}
	
	@RequestMapping(value="/employeeAddressList/{city}", method=RequestMethod.GET /*get method is used to retrieve a resource*/)
	public EmployeeAddress getEmployeeAddress(@PathVariable("city") String empAddressCity) { 
		EmployeeAddress empAddress = new EmployeeAddress();
		empAddress.setCity(empAddressCity);
		//empAddress.setCountry("India");

		return empAddress;
	}
	
	//Update a employee address record
	@RequestMapping(value="/employeeAddressList/{city}", method=RequestMethod.PUT, /*put method is used to update a resource*/
			consumes=MediaType.APPLICATION_JSON_VALUE /*It supports only json format and in Content-Type this format should be provided*/)
	public ResponseEntity<Boolean> updateEmployeeAddress(@PathVariable("city") String empAddressCity, @RequestBody EmployeeAddress empAddress) { 
		// @RequestBody - Spring will bind the incoming HTTP request body to that parameter. While doing that, Spring will [behind the scenes] use 
		// HTTP Message converters to convert the HTTP request body into domain object(the json/xml format to java object)
		//We need to mention Content-Type(the format should be specified in which the request body will be provided) and this step is mandatory
		System.out.println("Employee city : " +empAddressCity);
		System.out.println("Employee city : " +empAddress.getCity()+ " and country : " +empAddress.getCountry());
		
		//It will help us to display our own customized response headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Key1", "value1");
		headers.add("Key2", "value2");
		//return true;
		//return new ResponseEntity<Void>(HttpStatus.OK); It will send the status code in response
		return new ResponseEntity<Boolean>(true, headers, HttpStatus.OK); //It will send the response body as well as status code
	}
	
	//Create a new resource
	@RequestMapping(value="/employeeAddressList", method=RequestMethod.POST, /*post method is used to create a resource*/
			consumes=MediaType.APPLICATION_JSON_VALUE /*It supports only json format and in Content-Type this format should be provided*/)
	public ResponseEntity<Boolean> createEmployeeAddress(@RequestBody EmployeeAddress empAddress) { 

		System.out.println("Employee city : " +empAddress.getCity()+ " and country : " +empAddress.getCountry());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{city}")
				.buildAndExpand(empAddress.getCity()).toUri().toString()); //In response headers one customized
		//field "Location" gets displayed which contains the url which is required to retrieve this newly created
		//resource using get method
		
		return new ResponseEntity<Boolean>(true, headers, HttpStatus.CREATED); 
	}
}
