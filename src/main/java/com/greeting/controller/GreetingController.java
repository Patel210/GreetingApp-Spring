package com.greeting.controller;

import java.util.concurrent.atomic.AtomicLong; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@Autowired
	private IGreetingService greetingService;
	
	@GetMapping("/generate")
	public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName, 
							 @RequestParam(value = "lastName", defaultValue = "") String lastName ) {
		User user = new User(firstName, lastName);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping("/display/{id}")
	public Greeting greeting(@PathVariable long id) {
		return greetingService.getGreetingById(id);
	}
}
