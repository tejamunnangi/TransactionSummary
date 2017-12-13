package main.com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import main.com.beans.Product;
import main.com.dao.interfaces.ProductDAO;
import main.com.service.interfaces.ProductService;
import main.com.util.InputFileDescriptor;
import main.com.util.Utility;

public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	ProductService productService;

	@Override
	public Product getProductData(String transactionRow) {
		int[] locationIndices = new int[2];
		Product productInfo = new Product();
		
		String exchangeCodeLocation = InputFileDescriptor.getExchangeCodeLocation();
		locationIndices = Utility.getStartEndIndices(exchangeCodeLocation);
		productInfo.setExchangeCode(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String productGroupNumberLocation = InputFileDescriptor.getProductGroupCodeLocation();
		locationIndices = Utility.getStartEndIndices(productGroupNumberLocation);
		productInfo.setProdGroupCode(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String symbolLocation = InputFileDescriptor.getSymbolLocation();
		locationIndices = Utility.getStartEndIndices(symbolLocation);
		productInfo.setSymbol(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String exchangeDateLocation = InputFileDescriptor.getExchangeDateLocation();
		locationIndices = Utility.getStartEndIndices(exchangeDateLocation);
		productInfo.setExchangeDate(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		return productInfo;
	}
	
}
