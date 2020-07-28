package com.in28minutes.rest.webservices.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.rest.bean.User;
import com.in28minutes.rest.webservices.rest.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.rest.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/users")
	public List<User> retrieveAll() {
		return repository.getAll();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> getById(@PathVariable int id) {
		
		User user=repository.getById(id);
		if(user==null) 
			throw new UserNotFoundException("ID - " + id + " not found");
		Resource<User> resource=new Resource<User>(user);
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAll());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		User user=repository.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("ID - " + id + " not found");
		}
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Validated @RequestBody User user) {
		User savedUser=repository.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
