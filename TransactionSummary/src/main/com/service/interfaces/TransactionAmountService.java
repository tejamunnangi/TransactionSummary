package main.com.service.interfaces;

import main.com.beans.TransactionAmount;

public interface TransactionAmountService {
	/*
	 * Retrieves a transaction amount object from dao layer.
	 */
	public String getTransactionAmountInfo(String transactionRow);
	
	/*
	 * Combines and/or manipulates the content of transaction amount object for output consumption.
	 */
	public String buildTransactionAmountInfo(TransactionAmount transactionAmountInfo);
}
