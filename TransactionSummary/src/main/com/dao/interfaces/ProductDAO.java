package main.com.dao.interfaces;

import java.io.FileNotFoundException;

import main.com.beans.Product;

public interface ProductDAO {
	/*
	 * Extracts the product information from back-end.
	 */
	public Product getProductData(String transactionRow) throws FileNotFoundException;
}
