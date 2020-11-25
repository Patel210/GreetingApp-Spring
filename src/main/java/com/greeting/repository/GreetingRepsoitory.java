package com.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greeting.model.Greeting;

public interface GreetingRepsoitory extends JpaRepository<Greeting, Long> {

}
