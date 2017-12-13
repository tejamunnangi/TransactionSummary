package main.com.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.com.beans.Client;
import main.com.beans.Product;
import main.com.beans.TransactionAmount;
import main.com.dao.interfaces.ClientDAO;
import main.com.dao.interfaces.ProductDAO;
import main.com.dao.interfaces.TransactionAmountDAO;
import main.com.dao.interfaces.TransactionSummaryDAO;
import main.com.service.interfaces.ClientService;
import main.com.service.interfaces.ProductService;
import main.com.service.interfaces.TransactionAmountService;
import main.com.util.Constants;
import main.com.util.FileUtility;

public class TransactionSummaryDAOImpl implements TransactionSummaryDAO {

	private static final String INPUTFILENAME = "input.txt";
	
	@Autowired
	ClientDAO clientDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	TransactionAmountDAO transactionDAO;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	TransactionAmountService transactionAmountService;
	
	@Override
	public List<String> getTransactionSummaryData() {
		
		List<String> transactionSummaryData = new ArrayList<String>();
		
		File inputFile = FileUtility.getFileFromClasspath(INPUTFILENAME);
		String fileContent = FileUtility.getFileContent(inputFile);
		String[] transactionRows = fileContent.split("\n");
		
		for(String transactionRow : transactionRows) {
			
			Client clientInfo = clientDAO.getClientData(transactionRow);
			String clientData = clientService.buildClientInfo(clientInfo);
			
			Product productInfo = productDAO.getProductData(transactionRow);
			String productData = productService.buildProductInfo(productInfo);
			
			TransactionAmount transactionInfo = transactionDAO.getTransactionAmountData(transactionRow);
			String transactionData = transactionAmountService.buildTransactionAmountInfo(transactionInfo);
			
			transactionSummaryData.add(clientData + Constants.COMMA_DELIMITER + productData + Constants.COMMA_DELIMITER + transactionData);
		}
		
		return transactionSummaryData;
	}

}
