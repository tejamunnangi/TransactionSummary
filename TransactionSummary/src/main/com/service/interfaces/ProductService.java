package main.com.service.interfaces;

import main.com.beans.Product;

public interface ProductService {
	/*
	 * Retrieves a product object from dao layer.
	 */
	public String getProductInfo(String transactionRow);
	
	/*
	 * Combines and/or manipulates the content of product object for output consumption.
	 */
	public String buildProductInfo(Product productInfo);
}
