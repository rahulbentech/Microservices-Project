package com.in28minutes.rest.webservices.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28minutes.rest.webservices.rest.bean.UserLoginDetails;

@RestController
public class UserLoginFilterController {
	
	@GetMapping("/login")
	public MappingJacksonValue retrieveUserLoginDetails() {
		UserLoginDetails details=new UserLoginDetails(2408, "Rahul Ben", "key12345");
		
		SimpleBeanPropertyFilter beanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("email", "code");
		
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("user-login-filter", beanPropertyFilter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(details);
		mapping.setFilters(filterProvider);
		return mapping;
	}
	
	@GetMapping("/login-list")
	public MappingJacksonValue retrieveAllUserLoginDetails() {
		List<UserLoginDetails> list=Arrays.asList(new UserLoginDetails(2406, "David Beckham", "david-2422"), 
				new UserLoginDetails(2407, "Cherle Winson", "cherle0922"));
		
		SimpleBeanPropertyFilter beanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("email", "code");
		
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("user-login-filter", beanPropertyFilter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);
		return mapping;
	}

}
