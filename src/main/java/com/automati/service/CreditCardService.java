package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Person;
import com.automati.repo.CreditCardRepo;
import com.automati.service.interfaces.CreditCardServiceInterface;

@Service
@Transactional
public class CreditCardService implements CreditCardServiceInterface{
	
	@Autowired
	private CreditCardRepo cardRepo;
	
	@Override
	public void saveCard(CreditCard card) {
		cardRepo.save(card);
	}

	@Override
	public void deleteCard(CreditCard card) {
		cardRepo.delete(card);
	}

	@Override
	public void updateCard(CreditCard card) {
		cardRepo.saveAndFlush(card);
	}

	
	
}
