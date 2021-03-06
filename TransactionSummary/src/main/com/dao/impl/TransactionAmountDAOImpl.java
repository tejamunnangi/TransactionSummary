package main.com.dao.impl;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.com.beans.TransactionAmount;
import main.com.dao.interfaces.TransactionAmountDAO;
import main.com.util.FileUtility;
import main.com.util.InputFileDescriptor;
import main.com.util.Utility;

public class TransactionAmountDAOImpl implements TransactionAmountDAO {

	private static Logger logger = LoggerFactory.getLogger(FileUtility.class);
	
	@Override
	public TransactionAmount getTransactionAmountData(String transactionRow) throws FileNotFoundException {
		logger.debug("Trying to get the transaction amount data");
		int[] locationIndices = new int[2];
		TransactionAmount transactionAmount = new TransactionAmount();
		
		String quantityLongLocation = InputFileDescriptor.getQuantityLongLocation();
		locationIndices = Utility.getStartEndIndices(quantityLongLocation);
		String quantityLong = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		transactionAmount.setQuantityLong(quantityLong);
		
		String quantityShortLocation = InputFileDescriptor.getQuantityShortLocation();
		locationIndices = Utility.getStartEndIndices(quantityShortLocation);
		String quantityShort = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		transactionAmount.setQuantityShort(quantityShort);
		
		String exchBrokerFeeLocation = InputFileDescriptor.getExchBrokerFeeLocation();
		locationIndices = Utility.getStartEndIndices(exchBrokerFeeLocation);
		String exchangeBrokerFee = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		transactionAmount.setExchBrokerFee(exchangeBrokerFee);
		
		String clearFeeLocation = InputFileDescriptor.getClearingFeeLocation();
		locationIndices = Utility.getStartEndIndices(clearFeeLocation);
		String clearFee = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		transactionAmount.setClearingFee(clearFee);
		
		String commissionLocation = InputFileDescriptor.getCommissionLocation();
		locationIndices = Utility.getStartEndIndices(commissionLocation);
		String commission = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		transactionAmount.setCommission(commission);
		
		String transactionPriceLocation = InputFileDescriptor.getTransactionPriceLocation();
		locationIndices = Utility.getStartEndIndices(transactionPriceLocation);
		String transactionPrice = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		transactionAmount.setTransactionPrice(transactionPrice);
		logger.debug("Got the transaction price data");
		
		return transactionAmount;
	}

}
