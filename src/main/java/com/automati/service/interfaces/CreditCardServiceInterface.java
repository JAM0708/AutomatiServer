package com.automati.service.interfaces;

import java.util.Date;
import java.util.List;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;

public interface CreditCardServiceInterface  extends GenericServiceInterface {
	
	public List<CreditCard> findCreditCardsByUser(Person person);
	
	public Date getDateFromString(String dateString);
}
