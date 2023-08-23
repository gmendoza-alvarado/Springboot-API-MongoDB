package com.gonzalomendozafullstack.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gonzalomendozafullstack.model.Person;


public interface PersonService {
	
	
	public Iterable<Person> findAll();
	
	public Page<Person> findAll(Pageable pageable);
	
	public Optional<Person> findById(String id);
	
	public Person save(Person user);
	
	public void deleteById(String id);

}
