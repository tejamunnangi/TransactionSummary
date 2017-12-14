package test.java.mock;

import main.com.beans.TransactionAmount;

public class TransactionAmountMock extends TransactionAmount {
	private String quantityLong = "0000000001";
	private String quantityShort = "0000000000";
	private String exchBrokerFee = "000000000060";
	private String clearingFee = "000000000030";
	private String commission = "000000000000";
	private String transactionPrice = "000092500000000";
	
	public String getQuantityLong() {
		return quantityLong;
	}
	
	public String getQuantityShort() {
		return quantityShort;
	}
	
	public String getExchBrokerFee() {
		return exchBrokerFee;
	}
	
	public String getClearingFee() {
		return clearingFee;
	}
	
	public String getCommission() {
		return commission;
	}
	
	public String getTransactionPrice() {
		return transactionPrice;
	}
	
}
