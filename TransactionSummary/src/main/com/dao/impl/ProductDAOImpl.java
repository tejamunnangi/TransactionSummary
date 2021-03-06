package main.com.dao.impl;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import main.com.beans.Product;
import main.com.dao.interfaces.ProductDAO;
import main.com.service.interfaces.ProductService;
import main.com.util.FileUtility;
import main.com.util.InputFileDescriptor;
import main.com.util.Utility;

public class ProductDAOImpl implements ProductDAO {
	
	private static Logger logger = LoggerFactory.getLogger(FileUtility.class);
	
	@Autowired
	ProductService productService;

	@Override
	public Product getProductData(String transactionRow) throws FileNotFoundException {
		logger.debug("Trying to get the product information");
		int[] locationIndices = new int[2];
		Product productInfo = new Product();
		
		String exchangeCodeLocation = InputFileDescriptor.getExchangeCodeLocation();
		locationIndices = Utility.getStartEndIndices(exchangeCodeLocation);
		String exchangeCode = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setExchangeCode(exchangeCode);
		
		String productGroupNumberLocation = InputFileDescriptor.getProductGroupCodeLocation();
		locationIndices = Utility.getStartEndIndices(productGroupNumberLocation);
		String productGroupNumber = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setProdGroupCode(productGroupNumber);
		
		String symbolLocation = InputFileDescriptor.getSymbolLocation();
		locationIndices = Utility.getStartEndIndices(symbolLocation);
		String symbol = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setSymbol(symbol);
		
		String exchangeDateLocation = InputFileDescriptor.getExchangeDateLocation();
		locationIndices = Utility.getStartEndIndices(exchangeDateLocation);
		String exchangeDate = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setExchangeDate(exchangeDate);
		logger.debug("Got the product information for the product: "+productInfo);
		
		return productInfo;
	}
	
}
