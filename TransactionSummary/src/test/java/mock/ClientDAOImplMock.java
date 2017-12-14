package test.java.mock;

import java.io.FileNotFoundException;

import main.com.beans.Client;
import main.com.dao.interfaces.ClientDAO;
import main.com.util.InputFileDescriptor;
import main.com.util.Utility;

public class ClientDAOImplMock implements ClientDAO {
	
	public Client getClientData(String transactionRow) throws FileNotFoundException {
		
		int[] locationIndices = new int[2];
		String clientType;
		String clientNumber;
		String clientAccountNumber;
		String clientSubAccountNumber;
		
		Client clientInfo = new Client();
		
		String clientTypeLocation = InputFileDescriptor.getClientTypeLocation();
		locationIndices = Utility.getStartEndIndices(clientTypeLocation);
		clientType = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		clientInfo.setClientType(clientType);
		
		String clientNumberLocation = InputFileDescriptor.getClientNumberLocation();
		locationIndices = Utility.getStartEndIndices(clientNumberLocation);
		clientNumber = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		clientInfo.setClientNumber(clientNumber);
		
		String clientAccountNumberLocation = InputFileDescriptor.getClientAccountNumberLocation();
		locationIndices = Utility.getStartEndIndices(clientAccountNumberLocation);
		clientAccountNumber = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		clientInfo.setClientAccountNumber(clientAccountNumber);
		
		String clientSubAccountNumberLocation = InputFileDescriptor.getClientSubAccountNumberLocation();
		locationIndices = Utility.getStartEndIndices(clientSubAccountNumberLocation);
		clientSubAccountNumber = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		clientInfo.setClientSubAccountNumber(clientSubAccountNumber);
		
		return clientInfo;
	}
}
