package main.com.dao.interfaces;

import main.com.beans.TransactionAmount;

public interface TransactionAmountDAO {
	/*
	 * Extracts the transaction information from back-end.
	 */
	public TransactionAmount getTransactionAmountData(String transactionRow);
}
