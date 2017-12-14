package main.com.service.interfaces;

import java.io.FileNotFoundException;

import main.com.beans.Client;

public interface ClientService {
	
	/*
	 * Retrieves a client object from dao layer.
	 */
	public String getClientInfo(String transactionRow) throws FileNotFoundException;
	
	/*
	 * Combines and/or manipulates the client object for output consumption.
	 */
	public String buildClientInfo(Client clientInfo);
}
