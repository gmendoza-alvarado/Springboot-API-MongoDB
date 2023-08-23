package com.gonzalomendozafullstack.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalomendozafullstack.model.Person;
import com.gonzalomendozafullstack.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	PersonService personService;
	
	//Create Person
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Person person){
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
	}
	
	//Read an Person
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") String personId){
		Optional<Person> oPerson = personService.findById(personId);
		
		if(!oPerson.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPerson);		
		
	}
	
	//Update Person
		@PutMapping("/{id}")
		public ResponseEntity<?> update(@RequestBody Person person, @PathVariable(value = "id") String personId){
			Optional<Person> oPerson = personService.findById(personId);

			if(!oPerson.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			/*Fill entity
			oUser.get().setName(user.getName());
			oUser.get().setSurname(user.getSurname());
			oUser.get().setEmail(user.getEmail());
			oUser.get().setEnabled(user.getEnabled());
			
			//This other way to fill the properties (BeanUtils.copyProperties(user, oUser.get();)
			 * 
			 */
			
			return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(oPerson.get()));

		}

}
