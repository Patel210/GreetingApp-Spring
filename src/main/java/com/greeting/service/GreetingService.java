package com.greeting.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.greeting.model.Greeting;
import com.greeting.model.User;

@Service
public class GreetingService implements IGreetingService {
	
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	
	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "World" : user.toString());
		return new Greeting(counter.incrementAndGet(), message);
	}

	@Override
	public Greeting getGreetingById(long id) {
		return null;
	}
	
}
