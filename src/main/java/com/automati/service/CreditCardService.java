package com.automati.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;
import com.automati.dto.StatusCheck;
import com.automati.repo.CreditCardRepo;
import com.automati.service.interfaces.CreditCardServiceInterface;

@Service
@Transactional
public class CreditCardService implements CreditCardServiceInterface {

	@Autowired
	private CreditCardRepo cardRepo;
	
	@Autowired
	@Qualifier("status-check")
	private StatusCheck status;

	@Override
	public List<CreditCard> findCreditCardsByUser(Person person) {
		return cardRepo.findCreditCardByPerson(person);
	}

	@Override
	public <T> StatusCheck save(T object) {
		if (object instanceof CreditCard) {
			cardRepo.save((CreditCard) object);
			status.setPassedTrue();
			return status;
		} else {
			status.setPassedFalse();
			return status;
		}
	}

	@Override
	public <T> void delete(T object) {

	}

	@Override
	public <T> void update(T object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Date getDateFromString(String dateString) {
		Date  date = null;
		try {
			date = new SimpleDateFormat("MM-yyyy").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  date;
	}

}
