package main.com.dao.interfaces;

import java.io.FileNotFoundException;

import main.com.beans.TransactionAmount;

public interface TransactionAmountDAO {
	/*
	 * Extracts the transaction information from back-end.
	 */
	public TransactionAmount getTransactionAmountData(String transactionRow) throws FileNotFoundException;
}
