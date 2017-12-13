package main.com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import main.com.beans.Client;
import main.com.dao.interfaces.ClientDAO;
import main.com.service.interfaces.ClientService;
import main.com.util.InputFileDescriptor;
import main.com.util.Utility;

public class ClientDAOImpl implements ClientDAO {

	@Autowired
	ClientService clientService;
	
	@Override
	public Client getClientData(String transactionRow) {
		int[] locationIndices = new int[2];
		Client clientInfo = new Client();
		
		String clientTypeLocation = InputFileDescriptor.getClientTypeLocation();
		locationIndices = Utility.getStartEndIndices(clientTypeLocation);
		clientInfo.setClientType(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String clientNumberLocation = InputFileDescriptor.getClientNumberLocation();
		locationIndices = Utility.getStartEndIndices(clientNumberLocation);
		clientInfo.setClientNumber(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String clientAccountNumberLocation = InputFileDescriptor.getClientAccountNumberLocation();
		locationIndices = Utility.getStartEndIndices(clientAccountNumberLocation);
		clientInfo.setClientAccountNumber(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String clientSubAccountNumberLocation = InputFileDescriptor.getClientSubAccountNumberLocation();
		locationIndices = Utility.getStartEndIndices(clientSubAccountNumberLocation);
		clientInfo.setClientSubAccountNumber(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		return clientInfo;
	}

}
