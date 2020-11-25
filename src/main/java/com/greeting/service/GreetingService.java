package com.greeting.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.greeting.model.Greeting;

@Service
public class GreetingService implements IGreetingService {
	
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	
	@Override
	public Greeting addGreeting() {
		String message = "Hello World!";
		return new Greeting(counter.incrementAndGet(), message);
	}

	@Override
	public Greeting getGreetingById(long id) {
		return null;
	}
	
}
