package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.Person;
import com.automati.repo.PersonRepo;
import com.automati.service.interfaces.PersonServiceInterface;

@Service
@Transactional
public class PersonService implements PersonServiceInterface {

	@Autowired
	private PersonRepo personRepo;

	@Override
	public void savePerson(Person person) {
		personRepo.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		personRepo.delete(person);
	}

	@Override
	public List<Person> getPeople() {
		return personRepo.findPeople();
	}

	@Override
	public void updatePerson(Person person) {
		personRepo.saveAndFlush(person);
		
	}

	@Override
	public Person getPerson(int index) {
		return personRepo.findPersonByIndex(index);
	}

	@Override
	public Person getPerson(String email, String password) {
		return personRepo.findPersonByEmailAndPassword(email, password);
	}
	


}
