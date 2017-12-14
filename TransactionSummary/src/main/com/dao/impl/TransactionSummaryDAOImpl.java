package main.com.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger logger = LoggerFactory.getLogger(TransactionSummaryDAOImpl.class);
	
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
	public List<String> getTransactionSummaryData() throws FileNotFoundException {
		
		List<String> transactionSummaryData = new ArrayList<String>();
		
		InputStream inputFile;
		try {
			inputFile = FileUtility.getFileFromClasspath(INPUTFILENAME);
			logger.debug("Value of input file is from transaction summary is: "+inputFile);
			String fileContent = FileUtility.getFileContent(inputFile);
			logger.debug("Value of file content is from transaction summary is: "+fileContent);
			if(fileContent != null) {
				String[] transactionRows = fileContent.split(Constants.NEW_LINE_SEPARATOR);
				
				for(String transactionRow : transactionRows) {
					
					Client clientInfo = clientDAO.getClientData(transactionRow);
					String clientData = clientService.buildClientInfo(clientInfo);
					
					Product productInfo = productDAO.getProductData(transactionRow);
					String productData = productService.buildProductInfo(productInfo);
					
					TransactionAmount transactionInfo = transactionDAO.getTransactionAmountData(transactionRow);
					String transactionData = transactionAmountService.buildTransactionAmountInfo(transactionInfo);
					
					if(transactionData == null) {
						logger.error("Error occured while processing the transaction for the record with client info: "+clientData+" and product info: "+productData);
						continue;
					}
					
					transactionSummaryData.add(clientData + Constants.COMMA_DELIMITER + productData + Constants.COMMA_DELIMITER + transactionData);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("File, "+INPUTFILENAME+" not found in the classpath.");
			throw new FileNotFoundException();
		}
		return transactionSummaryData;
		
	}

}
