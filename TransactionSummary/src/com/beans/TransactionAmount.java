/*
 * POJO to hold information about fees and other amounts involved in a transaction
 */

package com.beans;

public class TransactionAmount {
	
	private Double quantityLong;
	private Double quantityShort;
	private Double exchBrokerFee;
	private Double clearingFee;
	private Double commission;
	private Double transactionPrice;
	
	public Double getQuantityLong() {
		return quantityLong;
	}
	public void setQuantityLong(Double quantityLong) {
		this.quantityLong = quantityLong;
	}
	public Double getQuantityShort() {
		return quantityShort;
	}
	public void setQuantityShort(Double quantityShort) {
		this.quantityShort = quantityShort;
	}
	public Double getExchBrokerFee() {
		return exchBrokerFee;
	}
	public void setExchBrokerFee(Double exchBrokerFee) {
		this.exchBrokerFee = exchBrokerFee;
	}
	public Double getClearingFee() {
		return clearingFee;
	}
	public void setClearingFee(Double clearingFee) {
		this.clearingFee = clearingFee;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	public Double getTransactionPrice() {
		return transactionPrice;
	}
	public void setTransactionPrice(Double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	
	@Override
	public String toString() {
		return "TransactionAmount [quantityLong=" + quantityLong + ", quantityShort=" + quantityShort
				+ ", exchBrokerFee=" + exchBrokerFee + ", clearingFee=" + clearingFee + ", commission=" + commission
				+ ", transactionPrice=" + transactionPrice + "]";
	}

}
