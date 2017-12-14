package main.com.dao.interfaces;

import java.io.FileNotFoundException;

import main.com.beans.Client;

public interface ClientDAO {
	/*
	 * Extracts the client information from back-end.
	 */
	public Client getClientData(String transactionRow) throws FileNotFoundException;
}
