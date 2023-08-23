package com.gonzalomendozafullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Person")
@Data
public class Person {
	
	@Id
	private String id;
	

	private String name;
	private String surname;
	private String email;
	private Integer age;

}

