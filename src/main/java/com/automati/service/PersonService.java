package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.Person;
import com.automati.dataentity.Role;
import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;
import com.automati.repo.PersonRepo;
import com.automati.repo.RoleRepo;
import com.automati.repo.StateRepo;
import com.automati.repo.ZipCodeRepo;
import com.automati.service.interfaces.PersonServiceInterface;

@Service
@Transactional
public class PersonService implements PersonServiceInterface {

	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private StateRepo stateRepo;
	
	@Autowired 
	private ZipCodeRepo zipCodeRepo;
	
	@Autowired
	private RoleRepo roleRepo;

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

	@Override
	public void saveState(State state) {
		stateRepo.save(state);
	}

	@Override
	public void saveZipCode(ZipCode zipcode) {
		zipCodeRepo.save(zipcode);
	}

	@Override
	public void saveRole(Role role) {
		roleRepo.save(role);
	}
	


}
