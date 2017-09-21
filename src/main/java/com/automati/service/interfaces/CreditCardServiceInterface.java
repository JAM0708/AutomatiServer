package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;

public interface CreditCardServiceInterface {
	public void saveCard(CreditCard card);
	
	public void deleteCard(CreditCard card);
	
	public void updateCard(CreditCard card);
	
	public List<CreditCard> findCreditCardsByUser(Person person);
}
