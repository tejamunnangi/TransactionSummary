package test.java.mock;

import main.com.beans.Client;

public class ClientMock extends Client {
	String clientType = "CL  ";
	String clientNumber = "4321";
	String clientAccountNumber = "0002";
	String clientSubAccountNumber = "0001";
	
	public String getClientType() {
		return clientType;
	}
	
	public String getClientNumber() {
		return clientNumber;
	}
	
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	
	public String getClientSubAccountNumber() {
		return clientSubAccountNumber;
	}
	
}
