/*
 * POJO to hold information about fees and other amounts involved in a transaction
 */

package main.com.beans;

public class TransactionAmount {
	
	private String quantityLong;
	private String quantityShort;
	private String exchBrokerFee;
	private String clearingFee;
	private String commission;
	private String transactionPrice;
	
	public String getQuantityLong() {
		return quantityLong;
	}
	public void setQuantityLong(String quantityLong) {
		this.quantityLong = quantityLong;
	}
	public String getQuantityShort() {
		return quantityShort;
	}
	public void setQuantityShort(String quantityShort) {
		this.quantityShort = quantityShort;
	}
	public String getExchBrokerFee() {
		return exchBrokerFee;
	}
	public void setExchBrokerFee(String exchBrokerFee) {
		this.exchBrokerFee = exchBrokerFee;
	}
	public String getClearingFee() {
		return clearingFee;
	}
	public void setClearingFee(String clearingFee) {
		this.clearingFee = clearingFee;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public String getTransactionPrice() {
		return transactionPrice;
	}
	public void setTransactionPrice(String transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	
	@Override
	public String toString() {
		return "TransactionAmount [quantityLong=" + quantityLong + ", quantityShort=" + quantityShort
				+ ", exchBrokerFee=" + exchBrokerFee + ", clearingFee=" + clearingFee + ", commission=" + commission
				+ ", transactionPrice=" + transactionPrice + "]";
	}

}
