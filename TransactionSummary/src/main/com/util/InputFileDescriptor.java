package main.com.util;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputFileDescriptor {
	public static final String INPUTDESCFILE = "InputDescriptor.txt";
	private static String descriptorFileContent;
	private static Logger logger = LoggerFactory.getLogger(InputFileDescriptor.class);
	
	private static String getDescriptorFile() throws FileNotFoundException{
		if(descriptorFileContent == null) {
			try {
				InputStream descriptorFile = FileUtility.getFileFromClasspath(INPUTDESCFILE);
				descriptorFileContent = FileUtility.getFileContent(descriptorFile);
			} catch (FileNotFoundException e) {
				logger.error("File, "+INPUTDESCFILE+" not found in the classpath.");
				throw new FileNotFoundException();
			}
			
		}
		return descriptorFileContent;
	}
	
	public static String getClientTypeLocation() throws FileNotFoundException {
		String clientTypeLocation = getValueFromFile("clientType");
		return clientTypeLocation;
	}
	
	public static String getClientNumberLocation() throws FileNotFoundException {
		String clientNumberLocation = getValueFromFile("clientNumber");
		return clientNumberLocation;
	}
	
	public static String getClientAccountNumberLocation() throws FileNotFoundException {
		String clientAccountNumberLocation = getValueFromFile("clientAccountNumber");
		return clientAccountNumberLocation;
	}
	
	public static String getClientSubAccountNumberLocation() throws FileNotFoundException {
		String clientSubAccountNumberLocation = getValueFromFile("clientSubAccountNumber");
		return clientSubAccountNumberLocation;
	}
	
	public static String getExchangeCodeLocation() throws FileNotFoundException {
		String exchangeCodeLocation = getValueFromFile("exchangeCode");
		return exchangeCodeLocation;
	}
	
	public static String getProductGroupCodeLocation() throws FileNotFoundException {
		String productGroupCodeLocation = getValueFromFile("productGroupCode");
		return productGroupCodeLocation;
	}
	
	public static String getSymbolLocation() throws FileNotFoundException {
		String symbolLocation = getValueFromFile("symbol");
		return symbolLocation;
	}
	
	public static String getExchangeDateLocation() throws FileNotFoundException {
		String exchangeDateLocation = getValueFromFile("expirationDate");
		return exchangeDateLocation;
	}
	
	public static String getQuantityLongLocation() throws FileNotFoundException {
		String quantityLongLocation = getValueFromFile("quantityLong");
		return quantityLongLocation;
	}
	
	public static String getQuantityShortLocation() throws FileNotFoundException {
		String quantityShortLocation = getValueFromFile("quantityShort");
		return quantityShortLocation;
	}
	
	public static String getExchBrokerFeeLocation() throws FileNotFoundException {
		String exchBrokerFeeLocation = getValueFromFile("exchBrokerFee");
		return exchBrokerFeeLocation;
	}
	
	public static String getClearingFeeLocation() throws FileNotFoundException {
		String clearingFeeLocation = getValueFromFile("clearingFee");
		return clearingFeeLocation;
	}
	
	public static String getCommissionLocation() throws FileNotFoundException {
		String commissionLocation = getValueFromFile("commission");
		return commissionLocation;
	}
	
	public static String getTransactionPriceLocation() throws FileNotFoundException {
		String transactionPriceLocation = getValueFromFile("transactionPrice");
		return transactionPriceLocation;
	}
	
	
	private static String getValueFromFile(String field) throws FileNotFoundException {
		String fileContent = getDescriptorFile();
		int startIndex = fileContent.indexOf(field+Constants.COLUMN_DELIMITER) + field.length() + 1;
		int endIndex = fileContent.indexOf(Constants.NEW_LINE_SEPARATOR, startIndex);
		String fieldValue = fileContent.substring(startIndex, endIndex);
		return fieldValue;
	}
	
}
