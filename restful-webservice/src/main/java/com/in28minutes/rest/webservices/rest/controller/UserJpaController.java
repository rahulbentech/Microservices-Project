package com.in28minutes.rest.webservices.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.in28minutes.rest.webservices.rest.repository.UserJpaRepository;

@RestController
public class UserJpaController {
	
	//@Autowired
	//private UserRepository repository;
	
	@Autowired
	private UserJpaRepository userRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> getById(@PathVariable int id) {
		
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) 
			throw new UserNotFoundException("ID - " + id + " not found");
		
		Resource<User> resource=new Resource<User>(user.get());
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAll());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable int id) {
		userRepository.deleteById(id);	
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> save(@Validated @RequestBody User user) {
		User savedUser=userRepository.save(user);
	
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}


}
