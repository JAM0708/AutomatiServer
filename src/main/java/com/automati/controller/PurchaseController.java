package com.automati.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Lease;
import com.automati.dataentity.Person;
import com.automati.dto.CreditCardDTO;
import com.automati.dto.LeaseDTO;
import com.automati.dto.StatusCheck;
import com.automati.service.interfaces.CarServiceInterface;
import com.automati.service.interfaces.CreditCardServiceInterface;
import com.automati.service.interfaces.PersonServiceInterface;

@RestController
public class PurchaseController {

	@Autowired
	PersonServiceInterface personService;
	
	@Autowired
	CreditCardServiceInterface creditCardService;
	
	@Autowired
	CarServiceInterface carService;
	
	@RequestMapping(path="/creditCard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusCheck  saveCreditCards(@RequestBody CreditCardDTO creditCardDTO) {
		Person person = personService.findPersonByEmail(creditCardDTO.getOwner().getEmail());
		Date date = creditCardService.getDateFromString(creditCardDTO.getExpDate());
		CreditCard creditCard = new CreditCard(creditCardDTO.getNumber(),  date, creditCardDTO.getCsc(), person);
		return creditCardService.save(creditCard);
	}
	
	@RequestMapping(path="/creditCard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CreditCard>> findCreditCardsByUser(@RequestParam("email") String userEmail) throws Exception {
		// check if the user exists
		Person person = personService.findPersonByEmail(userEmail);
		if(person == null) {
			String message = "Could not find person with email of " + userEmail;
			
			throw new Exception(message);
		}
		List<CreditCard> creditCards = creditCardService.findCreditCardsByUser(person);
		
		return ResponseEntity.ok(creditCards);
	}
	
	
	@RequestMapping(path="/card", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CreditCard> findCreditCardByID(@RequestParam("id") int id) throws Exception {
		CreditCard card = creditCardService.findCreditCardById(id);
		if(card  == null) {
			String message = "Could not find creditcard with id of " + id;
			
			throw new Exception(message);
		}
		return ResponseEntity.ok(card);
	}

	@RequestMapping(path="/lease", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveLease(@RequestBody LeaseDTO leaseDTO) {
		Lease feature = new Lease(leaseDTO);
		return carService.save(feature);
	}
}
