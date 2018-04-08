package com.automati.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.Car;
import com.automati.dataentity.Color;
import com.automati.dataentity.Condition;
import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Engine;
import com.automati.dataentity.Model;
import com.automati.dataentity.Person;
import com.automati.dataentity.Transaction;
import com.automati.dataentity.Transmission;
import com.automati.dto.CarDTO;
import com.automati.dto.StatusCheck;
import com.automati.dto.TransactionDTO;
import com.automati.service.interfaces.CreditCardServiceInterface;
import com.automati.service.interfaces.PersonServiceInterface;
import com.automati.service.interfaces.TransactionServiceInterface;


@RestController()
public class TransactionController {
	
	@Autowired
	private TransactionServiceInterface transactionService;
	
	@Autowired
	private PersonServiceInterface personService;
	
	@Autowired
	private CreditCardServiceInterface creditCardService;
	
	@RequestMapping(path = "/transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public ResponseEntity<List<Transaction>> getTransactions() throws Exception {
		List<Transaction> transactions = transactionService.getTransactions();
		
		if(!transactions.isEmpty()) {
			return ResponseEntity.ok(transactions);
		}
		else {
			throw new Exception("NO TRANSACTIONS FOUND!");
		}
	}
	
	@RequestMapping(path="/transaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck save(@RequestBody TransactionDTO transactionDTO) throws Exception {
		
		Person person = personService.findPersonByEmail(transactionDTO.getPerson().getEmail());
		if(person == null) {
			throw new Exception("Person NOT found");
		}
		CreditCard card = creditCardService.findCreditCardById(transactionDTO.getCard().getId());
		if(card == null) {
			throw new Exception("credit card not found");
		}
		Date now = new Date();
		Transaction transaction = new Transaction(transactionDTO.getAmount(), now, transactionDTO.getDescription(), person, card);
				
		return transactionService.save(transaction);
	}
}
