package com.in28minutes.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	// URI Versioning - Twitter
	@GetMapping("/person/v1")
	 public PersonV1 personV1() {
		 return new PersonV1("Bob Charlie");
	 }
	@GetMapping("/person/v2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	//Request Parameter Versioning - Amazon
	@GetMapping(value = "/person/param", params = "version=1")
	 public PersonV1 paramV1() {
		 return new PersonV1("Bob Charlie");
	 }
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	//Header Versioning (Custom) - Microsoft
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	 public PersonV1 headerV1() {
		 return new PersonV1("Bob Charlie");
	 }
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}

	//MediaType versioning- Content negotiation or accept header or mime type
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-V1+json")
	 public PersonV1 producesV1() {
		 return new PersonV1("Bob Charlie");
	 }
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-V2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
}
