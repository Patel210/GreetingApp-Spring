package com.greeting.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.repository.GreetingRepsoitory;

@Service
public class GreetingService implements IGreetingService {
	
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@Autowired
	private GreetingRepsoitory greetingRepository;
	
	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}
	
}
