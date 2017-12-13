/**
 * POJO to hold information related to client.
 * 
 */

package main.com.beans;

public class Client {
	private String clientType;
	private String clientNumber;
	private String clientAccountNumber;
	private String clientSubAccountNumber;
	
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public String getClientSubAccountNumber() {
		return clientSubAccountNumber;
	}
	public void setClientSubAccountNumber(String clientSubAccountNumber) {
		this.clientSubAccountNumber = clientSubAccountNumber;
	}
	
	@Override
	public String toString() {
		return "Client [clientType=" + clientType + ", clientNumber=" + clientNumber + ", clientAccountNumber="
				+ clientAccountNumber + ", clientSubAccountNumber=" + clientSubAccountNumber + "]";
	}
	
}
