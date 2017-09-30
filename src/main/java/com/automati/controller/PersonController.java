package com.automati.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.Car;
import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;
import com.automati.dataentity.Role;
import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;
import com.automati.dto.CreditCardDTO;
import com.automati.dto.PersonDTO;
import com.automati.dto.RoleDTO;
import com.automati.dto.StateDTO;
import com.automati.dto.StatusCheck;
import com.automati.dto.ZipCodeDTO;
import com.automati.service.interfaces.CreditCardServiceInterface;
import com.automati.service.interfaces.PersonServiceInterface;

@RestController
@RequestMapping("/user")
public class PersonController {
	
	private Logger logger = Logger.getLogger(PersonController.class);
	
	@Autowired
	PersonServiceInterface personService;
	
	@Autowired
	CreditCardServiceInterface creditCardService;
	
	@RequestMapping(path="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String login(@RequestBody PersonDTO personDTO) {
		return personService.getLoginToken(personDTO.getEmail(), personDTO.getPassword());
	}
	
	@RequestMapping(path="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck register(@RequestBody PersonDTO personDTO) {
		State state = personService.findStateByName(personDTO.getState().getName());
		Role role = personService.findRoleByName(personDTO.getRole().getName());
		Person person = new Person(personDTO, state, role);
		return personService.save(person);
	}
	
	@RequestMapping(path="/creditCard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusCheck  saveCreditCards(@RequestBody CreditCardDTO creditCardDTO) {
		Person person = personService.findPersonByEmail(creditCardDTO.getOwner().getEmail());
		CreditCard creditCard = new CreditCard(creditCardDTO.getNumber(),  creditCardDTO.getExpDate(), creditCardDTO.getCsc(), person);
		return creditCardService.save(creditCard);
		
	}
	
	@RequestMapping(path="/creditCard", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CreditCard> findCreditCardsByUser(@RequestParam("email") String userEmail) {
		Person person = personService.findPersonByEmail(userEmail);
		return creditCardService.findCreditCardsByUser(person);
	}
	
	@RequestMapping(path="/zipcode", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ZipCode> findZipCodesByState(@RequestParam("state") String stateName) {
		State state = personService.findStateByName(stateName);
		return personService.getStateWithZipCodes(state);
	}

	@RequestMapping(path="/state", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck  saveState(@RequestBody StateDTO stateDTO) {
		Set<ZipCode> codes = new HashSet<>();
		logger.info(stateDTO.toString());
		State state = new State(stateDTO.getName(), codes);
		personService.save(state);
		Iterator<ZipCodeDTO> itr = stateDTO.getCodes().iterator();
		while(itr.hasNext()) {
			ZipCode zipcode = new ZipCode(itr.next().getCode());
			zipcode.setState(state);
			state.getCode().add(zipcode);
			personService.save(zipcode);
		}
		logger.info("ZipCodeList Size " + codes.size());
		return new StatusCheck(true);
	}
	
	@RequestMapping(path="/role", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveRole(@RequestBody RoleDTO roleDTO) {
		Role role = new Role(roleDTO.getName());
		return personService.save(role);
	}
	
	@RequestMapping(path="/state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<State> getAllStates() {
		return personService.getAllStates();
	}
}
