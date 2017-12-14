package test.java.mock;

import main.com.beans.Product;

public class ProductMock extends Product {
	private String exchangeCode = "SGX ";
	private String prodGroupCode = "FU";
	private String symbol = "NK    ";
	private String exchangeDate = "20100910";
	
	public String getExchangeCode() {
		return exchangeCode;
	}
	
	public String getProdGroupCode() {
		return prodGroupCode;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getExchangeDate() {
		return exchangeDate;
	}
}
