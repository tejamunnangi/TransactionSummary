package main.com.service.impl;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import main.com.beans.Product;
import main.com.dao.interfaces.ProductDAO;
import main.com.service.interfaces.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public String getProductInfo(String transactionRow) throws FileNotFoundException {
		Product productData = productDAO.getProductData(transactionRow);
		String productInfo = buildProductInfo(productData);
		return productInfo;
	}

	@Override
	public String buildProductInfo(Product productInfo) {
		return productInfo.getExchangeCode() + productInfo.getProdGroupCode() 
				+ productInfo.getSymbol() + productInfo.getExchangeDate();
	}

}
