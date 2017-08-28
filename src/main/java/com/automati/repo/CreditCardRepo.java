package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;

public interface CreditCardRepo extends JpaRepository<CreditCard, Integer> {	
	
	List<CreditCard> findCreditCardByPerson(Person person);
}
