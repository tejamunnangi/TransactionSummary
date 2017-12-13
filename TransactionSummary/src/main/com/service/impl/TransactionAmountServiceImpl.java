package main.com.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import main.com.beans.TransactionAmount;
import main.com.dao.interfaces.TransactionAmountDAO;
import main.com.service.interfaces.TransactionAmountService;
import main.com.util.Utility;

public class TransactionAmountServiceImpl implements TransactionAmountService {
	
	private static Logger logger = LoggerFactory.getLogger(TransactionAmountServiceImpl.class);
	
	@Autowired
	TransactionAmountDAO transactionAmountDAO;

	@Override
	public String getTransactionAmountInfo(String transactionRow) {
		TransactionAmount transactionAmountData = transactionAmountDAO.getTransactionAmountData(transactionRow);
		String transactionAmountInfo = buildTransactionAmountInfo(transactionAmountData);
		return transactionAmountInfo;
	}

	@Override
	public String buildTransactionAmountInfo(TransactionAmount transactionAmountInfo) {
		try {
			Double quantityLong = Double.valueOf(Utility.removeTrailingZeros(transactionAmountInfo.getQuantityLong()));
			Double quantityShort = Double.valueOf(Utility.removeTrailingZeros(transactionAmountInfo.getQuantityShort()));
			Double exchBrokerFee = Double.valueOf(Utility.removeTrailingZeros(transactionAmountInfo.getExchBrokerFee()));
			Double clearingFee = Double.valueOf(Utility.removeTrailingZeros(transactionAmountInfo.getClearingFee()));
			Double commission = Double.valueOf(Utility.removeTrailingZeros(transactionAmountInfo.getCommission()));
			Double transactionPrice = Double.valueOf(Utility.removeTrailingZeros(transactionAmountInfo.getTransactionPrice()));
			Double transactionAmount = (quantityLong - quantityShort) * (transactionPrice - commission - clearingFee - exchBrokerFee);
			return String.valueOf(transactionAmount);
		}
		catch(NumberFormatException e) {
			logger.error("Exception occured while processing transaction record. Please check the input file and process again.");
			return null;
		}
		
		
	}

}
