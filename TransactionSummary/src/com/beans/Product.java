/*
 * POJO to hold information related to product.
 */

package com.beans;

public class Product {
	
	private String exchangeCode;
	private String prodGroupCode;
	private String symbol;
	private String exchangeDate;
	
	public String getExchangeCode() {
		return exchangeCode;
	}
	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	public String getProdGroupCode() {
		return prodGroupCode;
	}
	public void setProdGroupCode(String prodGroupCode) {
		this.prodGroupCode = prodGroupCode;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExchangeDate() {
		return exchangeDate;
	}
	public void setExchangeDate(String exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	
	@Override
	public String toString() {
		return "Product [exchangeCode=" + exchangeCode + ", prodGroupCode=" + prodGroupCode + ", symbol=" + symbol
				+ ", exchangeDate=" + exchangeDate + "]";
	}
	
	
	
}
