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

import javassist.expr.Instanceof;

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

	/*
	 * @Autowired
	 * 
	 * @Qualifier("jwtutils") JWTUtils jwtUtils;
	 */

	@Override
	public List<Person> getPeople() {
		return personRepo.findAll();
	}

	@Override
	public Person getPerson(int index) {
		return personRepo.findOne(index);
	}

	@Override
	public String getLoginToken(String email, String password) {
		Person person = personRepo.findPersonByEmail(email);
		String token = "No User Found";
		if (person != null && passwordEncoder.matches(password, person.getPassword())) {
			JWTUtils jwtUtils = new JWTUtils();
			token = jwtUtils.createJWT(person.getId() + "", "Automati Server", 100000, person);
		}
		return token;
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

	@Override
	public <T> void save(T object) {
		if (object instanceof State) {

			stateRepo.save((State) object);
		} else if (object instanceof Role) {

			roleRepo.save((Role) object);
		} else if (object instanceof ZipCode) {

			zipCodeRepo.save((ZipCode) object);
		} else if (object instanceof Person) {

			Person person = (Person) object;
			person.setPassword(passwordEncoder.encode(person.getPassword()));
			personRepo.save(person);

		}
	}

	@Override
	public <T> void delete(T object) {
		if (object instanceof Person) {
			personRepo.delete((Person) object);
		}

	}

	@Override
	public <T> void update(T object) {
		if (object instanceof Person) {
			personRepo.save((Person) object);
		}
	}

}
