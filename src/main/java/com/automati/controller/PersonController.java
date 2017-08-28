package com.automati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.dto.PersonDTO;
import com.automati.service.interfaces.PersonServiceInterface;

@RestController
public class PersonController {
	
	@Autowired
	PersonServiceInterface personService;
	
	@RequestMapping(path="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Person login(@RequestBody PersonDTO personDTO) {
		Person person = new Person(personDTO);
		return personService.getPerson(person.getEmail(), person.getPassword());
	}
	
	@RequestMapping(path="/register", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void register(@RequestBody PersonDTO personDTO) {
		Person person = new Person(personDTO);
		personService.savePerson(person);
	}

}
