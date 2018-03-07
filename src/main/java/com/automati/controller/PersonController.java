package com.automati.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.automati.dataentity.Car;
import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;
import com.automati.dataentity.ResetToken;
import com.automati.dataentity.Role;
import com.automati.dataentity.Shipping;
import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;
import com.automati.dto.CreditCardDTO;
import com.automati.dto.JwtDTO;
import com.automati.dto.PersonDTO;
import com.automati.dto.ResetTokenDTO;
import com.automati.dto.RoleDTO;
import com.automati.dto.ShippingDTO;
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
	public ResponseEntity<JwtDTO> login(@RequestBody PersonDTO personDTO) {
		JwtDTO token = personService.getLoginToken(personDTO.getEmail(), personDTO.getPassword());
		return new ResponseEntity<JwtDTO>(token, HttpStatus.OK);
	}
	
	@RequestMapping(path="/forgotPassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> forgotPassword(@RequestBody PersonDTO personDTO) {
		Person person = personService.findPersonByEmail(personDTO.getEmail());
		if(person == null) {
			return new ResponseEntity<StatusCheck>(new StatusCheck(false), HttpStatus.OK);
		} else {
			final Context ctx = new Context();
			ctx.setVariable("name", person.getFirstName() + " " + person.getLastName());
			ctx.setVariable("imageResourceName", "token.jpg");
			int tokenNum = (int) (Math.random() * person.getId()) * 5;
			ctx.setVariable("url", "localhost:4200/passwordReset?token=" + tokenNum + person.getEmail() );
			StatusCheck status = personService.sendEmail(person.getEmail(), ctx, "passwordToken", "token.jpg", "passwordToken");
			if(status.isPassed()) {
				status = personService.storeToken(new ResetToken(tokenNum, person.getEmail()));
			}
			return new ResponseEntity<StatusCheck>(status, HttpStatus.OK);
		}
	}
	
	@RequestMapping(path="/passwordReset", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> passwordReset(@RequestBody ResetTokenDTO resetTokenDTO) {
		ResetToken token = new ResetToken(resetTokenDTO.getTokenNum(), resetTokenDTO.getEmail());
		ResetToken result = personService.findToken(token);
		if(result == null) {
			return new ResponseEntity<StatusCheck>(new  StatusCheck(false), HttpStatus.OK);
		} else {
			return new ResponseEntity<StatusCheck>(new  StatusCheck(true), HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(path="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> register(@RequestBody PersonDTO personDTO) {
		State state = personService.findStateByName(personDTO.getState().getName());
		Role role = personService.findRoleByName(personDTO.getRole().getName());
		Person person = new Person(personDTO, state, role);
		StatusCheck results = personService.save(person);
		return new ResponseEntity<StatusCheck>(results, HttpStatus.OK);
	}
	
	@RequestMapping(path="/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody PersonDTO personDTO) {
		State state = personService.findStateByName(personDTO.getState().getName());
		Role role = personService.findRoleByName(personDTO.getRole().getName());
		Person person = new Person(personDTO, state, role);
		personService.update(person);
	}
	
	@RequestMapping(path="/zipcode", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ZipCode>> findZipCodesByState(@RequestParam("state") String stateName) {
		State state = personService.findStateByName(stateName);
		List<ZipCode> zipCode = personService.getStateWithZipCodes(state);
		return new ResponseEntity<List<ZipCode>>(zipCode, HttpStatus.OK);
	}

	@RequestMapping(path="/state", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck>   saveState(@RequestBody StateDTO stateDTO) {
		State state = new State(stateDTO.getName());
		Iterator<ZipCodeDTO> codes =  stateDTO.getCodes().iterator();
		for(ZipCodeDTO code: stateDTO.getCodes()) {
			state.addZipCode(code.getCode());
		}
		StatusCheck results = personService.save(state);
		return new ResponseEntity<StatusCheck>(results, HttpStatus.OK);
	}
	
	@RequestMapping(path="/role", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck>  saveRole(@RequestBody RoleDTO roleDTO) {
		Role role = new Role(roleDTO.getName());
		StatusCheck results = personService.save(role);
		return new ResponseEntity<StatusCheck>(results, HttpStatus.OK);
	}
	
	@RequestMapping(path="/state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<State>> getAllStates() {
		return new ResponseEntity<List<State>>( personService.getAllStates(), HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/userEmail", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> findByUserbyEmail(@RequestParam("email") String email) {
		Person person = personService.findPersonByEmail(email);
		return new ResponseEntity<Person> (person, HttpStatus.OK);
	}
	

	@RequestMapping(path="/updateShipping", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateShipping(@RequestBody ShippingDTO shippingDTO) {
		Person person = personService.findPersonByEmail(shippingDTO.getPerson().getEmail());
		State state = personService.findStateByName(shippingDTO.getState().getName());
		Shipping shipping = new Shipping(shippingDTO, person, state);
		personService.update(shipping);
	}
	
	@RequestMapping(path = "/shipsAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Shipping>> findShippingAddressesByUser(@RequestParam("email") String userEmail) {
		Person person = personService.findPersonByEmail(userEmail);
		return new ResponseEntity<List<Shipping>>(personService.findShippingsByPerson(person), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/shipAddr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shipping> findShippingAddressById(@RequestParam("id") int id) {
		return new ResponseEntity<Shipping>(personService.findShippingAddressById(id), HttpStatus.OK);
	}
	
	
}
