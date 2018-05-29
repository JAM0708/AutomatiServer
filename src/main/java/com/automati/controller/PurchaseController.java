package com.automati.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	public List<CreditCard> findCreditCardsByUser(@RequestParam("email") String userEmail) {
		Person person = personService.findPersonByEmail(userEmail);
		return creditCardService.findCreditCardsByUser(person);
	}
	
	
	@RequestMapping(path="/card", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CreditCard findCreditCardByID(@RequestParam("id") int id) {
		CreditCard card = creditCardService.findCreditCardById(id);
		return card;
	}
	
	@RequestMapping(path="/cardNumber", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CreditCard findCreditCardByNumber(@RequestParam("number") int number) {
		CreditCard card = creditCardService.findCreditCardById(number);
		return card;
	}

	@RequestMapping(path="/lease", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveLease(@RequestBody LeaseDTO leaseDTO) {
		Lease feature = new Lease(leaseDTO);
		return carService.save(feature);
	}
}
