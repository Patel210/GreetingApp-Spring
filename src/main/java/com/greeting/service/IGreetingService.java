package com.greeting.service;

import com.greeting.model.Greeting;

public interface IGreetingService {
	Greeting addGreeting();
	Greeting getGreetingById(long id);
}
