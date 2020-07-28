package com.in28minutes.rest.webservices.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.rest.bean.AppBean;

//Controller
@RestController
public class AppController {
	
	@Autowired
	private MessageSource messageSource;
	
	//GET
	//Request-Method
	//URI
	//@RequestMapping(method = RequestMethod.GET, path = "/message")
	@GetMapping(path = "/message")
	public String message() {
		return "Welcome to rest webservice";
	}
	
	@GetMapping(path = "/messagebean")
	public AppBean message8() {
		return new AppBean("Bean of rest service");
	}

	@GetMapping("/appinter")
	public String AppInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
}
