package com.gonzalomendozafullstack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonzalomendozafullstack.model.Person;
import com.gonzalomendozafullstack.repository.PersonRepository;

@Service
public class PersonServideImpl implements PersonService{
	

	@Autowired
	PersonRepository personRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Person> findAll(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Person> findById(String id) {
		return personRepository.findById(id);
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deleteById(String id) {
		personRepository.deleteById(id);
		
	}

}
