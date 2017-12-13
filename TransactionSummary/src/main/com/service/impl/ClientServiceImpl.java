package main.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import main.com.beans.Client;
import main.com.dao.interfaces.ClientDAO;
import main.com.service.interfaces.ClientService;

public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientDAO clientDAO;
	
	@Override
	public String getClientInfo(String transactionRow) {
		Client clientData = clientDAO.getClientData(transactionRow);
		String clientInfo = buildClientInfo(clientData);
		return clientInfo;
	}
	
	@Override
	public String buildClientInfo(Client clientInfo) {
		return clientInfo.getClientType() + clientInfo.getClientNumber() 
					+ clientInfo.getClientAccountNumber() 
						+ clientInfo.getClientSubAccountNumber();
	}

}
