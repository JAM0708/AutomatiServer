package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Transaction;

public interface TransactionServiceInterface extends GenericServiceInterface{
	
	public List<Transaction> getTransactions();

}
