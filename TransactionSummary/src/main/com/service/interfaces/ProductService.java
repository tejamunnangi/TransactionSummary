package main.com.service.interfaces;

import java.io.FileNotFoundException;

import main.com.beans.Product;

public interface ProductService {
	/*
	 * Retrieves a product object from dao layer.
	 */
	public String getProductInfo(String transactionRow) throws FileNotFoundException;
	
	/*
	 * Combines and/or manipulates the content of product object for output consumption.
	 */
	public String buildProductInfo(Product productInfo);
}
