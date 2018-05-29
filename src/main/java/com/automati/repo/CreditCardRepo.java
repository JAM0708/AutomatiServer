package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Integer> {	
	
	List<CreditCard> findCreditCardByPerson(Person person);
	
	CreditCard findCreditCardByNumber(int number);
	
}
