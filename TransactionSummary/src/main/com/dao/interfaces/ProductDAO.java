package main.com.dao.interfaces;

import main.com.beans.Product;

public interface ProductDAO {
	/*
	 * Extracts the product information from back-end.
	 */
	public Product getProductData(String transactionRow);
}
