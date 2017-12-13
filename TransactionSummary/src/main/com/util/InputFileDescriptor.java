package main.com.util;

import java.io.File;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputFileDescriptor {
	public static final String INPUTDESCFILE = "InputDescriptor.txt";
	private static String descriptorFileContent;
	private static Logger logger = LoggerFactory.getLogger(InputFileDescriptor.class);
	
	private static String getDescriptorFile(){
		if(descriptorFileContent != null) {
			try {
				File descriptorFile = FileUtility.getFileFromClasspath(INPUTDESCFILE);
				descriptorFileContent = FileUtility.getFileContent(descriptorFile);
			} catch (FileNotFoundException e) {
				logger.error("File, "+INPUTDESCFILE+" not found in the classpath.");
			}
			
		}
		return descriptorFileContent;
	}
	
	public static String getClientTypeLocation() {
		String clientTypeLocation = getValueFromFile("clientType");
		return clientTypeLocation;
	}
	
	public static String getClientNumberLocation() {
		String clientNumberLocation = getValueFromFile("clientNumber");
		return clientNumberLocation;
	}
	
	public static String getClientAccountNumberLocation() {
		String clientAccountNumberLocation = getValueFromFile("clientAccountNumber");
		return clientAccountNumberLocation;
	}
	
	public static String getClientSubAccountNumberLocation() {
		String clientSubAccountNumberLocation = getValueFromFile("clientSubAccountNumber");
		return clientSubAccountNumberLocation;
	}
	
	public static String getExchangeCodeLocation() {
		String exchangeCodeLocation = getValueFromFile("exchangeCode");
		return exchangeCodeLocation;
	}
	
	public static String getProductGroupCodeLocation() {
		String productGroupCodeLocation = getValueFromFile("productGroupCode");
		return productGroupCodeLocation;
	}
	
	public static String getSymbolLocation() {
		String symbolLocation = getValueFromFile("symbol");
		return symbolLocation;
	}
	
	public static String getExchangeDateLocation() {
		String exchangeDateLocation = getValueFromFile("exchangeLocation");
		return exchangeDateLocation;
	}
	
	public static String getQuantityLongLocation() {
		String quantityLongLocation = getValueFromFile("quantityLong");
		return quantityLongLocation;
	}
	
	public static String getQuantityShortLocation() {
		String quantityShortLocation = getValueFromFile("quantityShort");
		return quantityShortLocation;
	}
	
	public static String getExchBrokerFeeLocation() {
		String exchBrokerFeeLocation = getValueFromFile("exchBrokerFee");
		return exchBrokerFeeLocation;
	}
	
	public static String getClearingFeeLocation() {
		String clearingFeeLocation = getValueFromFile("clearingFee");
		return clearingFeeLocation;
	}
	
	public static String getCommissionLocation() {
		String commissionLocation = getValueFromFile("commission");
		return commissionLocation;
	}
	
	public static String getTransactionPriceLocation() {
		String transactionPriceLocation = getValueFromFile("transactionPrice");
		return transactionPriceLocation;
	}
	
	
	private static String getValueFromFile(String field) {
		String fileContent = getDescriptorFile();
		int startIndex = fileContent.indexOf(field);
		int endIndex = fileContent.indexOf("\n", startIndex);
		String fieldValue = fileContent.substring(startIndex, endIndex);
		return fieldValue;
	}
	
}
