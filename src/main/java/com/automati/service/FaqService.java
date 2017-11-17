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
import com.automati.dataentity.Faq;
import com.automati.dataentity.Person;
import com.automati.dto.StatusCheck;
import com.automati.repo.CreditCardRepo;
import com.automati.repo.FaqRepo;
import com.automati.service.interfaces.CreditCardServiceInterface;
import com.automati.service.interfaces.FaqServiceInterface;

@Service
@Transactional
public class FaqService implements FaqServiceInterface {

	@Autowired
	private FaqRepo faqRepo;
	
	@Override
	public List<Faq> getFaqs() {
		// TODO Auto-generated method stub
		return faqRepo.findAll();
	}

	@Override
	public <T> StatusCheck save(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void delete(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void update(T object) {
		// TODO Auto-generated method stub
		
	}

}
