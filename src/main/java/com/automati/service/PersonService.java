package com.automati.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.config.security.JWTUtils;
import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.dataentity.Role;
import com.automati.dataentity.Shipping;
import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;
import com.automati.dto.JwtDTO;
import com.automati.dto.StatusCheck;
import com.automati.repo.PersonRepo;
import com.automati.repo.RoleRepo;
import com.automati.repo.ShippingRepo;
import com.automati.repo.StateRepo;
import com.automati.repo.ZipCodeRepo;
import com.automati.service.interfaces.PersonServiceInterface;

import javassist.expr.Instanceof;

@Service
@Transactional
public class PersonService implements PersonServiceInterface {

	private Logger logger = Logger.getLogger(PersonService.class);
	
	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private ZipCodeRepo zipCodeRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private ShippingRepo shippingRepo;

	@Autowired
	@Qualifier("brcypt")
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("status-check")
	private StatusCheck status;
	
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
	public JwtDTO getLoginToken(String email, String password) {
		Person person = personRepo.findPersonByEmail(email);
		String tokenString = "No User Found";
		boolean isJWT = false;
		if (person != null && passwordEncoder.matches(password, person.getPassword())) {
			JWTUtils jwtUtils = new JWTUtils();
			tokenString = jwtUtils.createJWT(person.getId() + "", "Automati Server", 18000000, person);
			isJWT =true;
		}
		logger.info(" is JWT" + isJWT);
		return new JwtDTO(tokenString, isJWT);
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
		Person person = personRepo.findPersonByEmail(email);
		//if(person != null) {
		//System.out.println(person.getCreditCard());
		//}
		return person;
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
	public <T> StatusCheck  save(T object) {
		boolean passed = false;
		if (object instanceof State) {
			stateRepo.save((State) object);
			passed = true;
		} else if (object instanceof Role) {
			roleRepo.save((Role) object);
			passed =true;
		} else if (object instanceof ZipCode) {
			zipCodeRepo.save((ZipCode) object);
			passed =true;
		} else if (object instanceof Person) {
			Person person = (Person) object;
			if(findPersonByEmail(person.getEmail()) == null) {
			person.setPassword(passwordEncoder.encode(person.getPassword()));
			personRepo.save(person);
			passed =true;
			} else {
				passed = false;
			}
		}
		if(passed) {
			status.setPassedTrue();
			return status;
		} else {
			status.setPassedFalse();
			return status;
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
			Person person = (Person) object;
			// person.setPassword(passwordEncoder.encode(person.getPassword()));
			logger.info(person.toString());
			personRepo.save((Person) object);
			
		}
		else if(object instanceof Shipping) {
			shippingRepo.save((Shipping) object);
		}
	}

	@Override
	public List<Shipping> findShippingsByPerson(Person person) {
		// TODO Auto-generated method stub
		return shippingRepo.findShippingsByPerson(person);
	}

	@Override
	public Shipping findShippingAddressById(int id) {
	
		Shipping shipping = shippingRepo.findOne(id);
		if(shipping != null) {
			System.out.println(shipping.getPerson().toString());
		}
		return shipping;
	}

}
