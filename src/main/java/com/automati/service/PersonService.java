package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.config.security.JWTUtils;
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
	
	@Autowired
	@Qualifier("brcypt")
	private BCryptPasswordEncoder passwordEncoder;
	
	/*@Autowired
	@Qualifier("jwtutils")
	JWTUtils jwtUtils;*/

	@Override
	public void savePerson(Person person) {
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		personRepo.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		personRepo.delete(person);
	}

	@Override
	public List<Person> getPeople() {
		return personRepo.findAll();
	}

	@Override
	public void updatePerson(Person person) {
		personRepo.saveAndFlush(person);
		
	}

	@Override
	public Person getPerson(int index) {
		return personRepo.findOne(index);
	}

	@Override
	public String getLoginToken(String email, String password) {
		Person person =personRepo.findPersonByEmail(email);
		String token = "No User Found";
		if(person != null && passwordEncoder.matches(password, person.getPassword()) ) {
			JWTUtils jwtUtils = new JWTUtils();
			token = jwtUtils.createJWT(person.getId() + "", "Automati Server", 100000, person);
		}
		return token;
	}

	@Override
	public void saveState(State state) {
		stateRepo.saveAndFlush(state);
	}

	@Override
	public void saveZipCode(ZipCode zipcode) {
		zipCodeRepo.save(zipcode);
	}

	@Override
	public void saveRole(Role role) {
		roleRepo.save(role);
	}

	@Override
	public List<ZipCode> getStateWithZipCodes(State state) {
		return zipCodeRepo.findZipCodeByState(state);
	}

	@Override
	public List<State> getAllStates() {
		return stateRepo.findAll();
	}

	@Override
	public Person findPersonByEmail(String email) {
		return personRepo.findPersonByEmail(email);
	}

	@Override
	public State findStateByName(String name) {
		return stateRepo.findStateByName(name);
	}

	@Override
	public Role findRoleByName(String name) {
		return roleRepo.findRoleByName(name);
	}
	
	
	

}
