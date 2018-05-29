package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.Transaction;
import com.automati.dto.StatusCheck;
import com.automati.repo.TransactionRepo;
import com.automati.service.interfaces.TransactionServiceInterface;

@Service
@Transactional
public class TransactionService implements TransactionServiceInterface{

	@Autowired
	private TransactionRepo transactionRepo; 
	
	@Autowired
	@Qualifier("status-check")
	private StatusCheck status;
	
	@Override
	public <T> StatusCheck save(T object) {
		boolean passed = false;
		if(object instanceof Transaction) {
			//person.addTransaction(transaction);
			transactionRepo.save((Transaction) object);
			passed = true;
		}
		
		if(passed) {
			status.setPassedTrue();
			return status;
		}
		else {
			status.setPassedFalse();
			return status;
		}
	}

	@Override
	public <T> void delete(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void update(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return transactionRepo.findAll();
	}

}
