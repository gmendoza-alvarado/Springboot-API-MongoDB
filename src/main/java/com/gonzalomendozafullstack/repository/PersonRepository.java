package com.gonzalomendozafullstack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gonzalomendozafullstack.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

}
