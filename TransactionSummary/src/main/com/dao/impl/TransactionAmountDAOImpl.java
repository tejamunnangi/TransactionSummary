package main.com.dao.impl;

import main.com.beans.TransactionAmount;
import main.com.dao.interfaces.TransactionAmountDAO;
import main.com.util.InputFileDescriptor;
import main.com.util.Utility;

public class TransactionAmountDAOImpl implements TransactionAmountDAO {

	@Override
	public TransactionAmount getTransactionAmountData(String transactionRow) {
		int[] locationIndices = new int[2];
		TransactionAmount transactionAmount = new TransactionAmount();
		
		String quantityLong = InputFileDescriptor.getQuantityLongLocation();
		locationIndices = Utility.getStartEndIndices(quantityLong);
		transactionAmount.setQuantityLong(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String quantityShort = InputFileDescriptor.getQuantityShortLocation();
		locationIndices = Utility.getStartEndIndices(quantityShort);
		transactionAmount.setQuantityShort(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String exchBrokerFee = InputFileDescriptor.getExchBrokerFeeLocation();
		locationIndices = Utility.getStartEndIndices(exchBrokerFee);
		transactionAmount.setExchBrokerFee(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String clearFee = InputFileDescriptor.getClearingFeeLocation();
		locationIndices = Utility.getStartEndIndices(clearFee);
		transactionAmount.setClearingFee(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String commission = InputFileDescriptor.getCommissionLocation();
		locationIndices = Utility.getStartEndIndices(commission);
		transactionAmount.setCommission(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		String transactionPrice = InputFileDescriptor.getTransactionPriceLocation();
		locationIndices = Utility.getStartEndIndices(transactionPrice);
		transactionAmount.setTransactionPrice(transactionRow.substring(locationIndices[0], locationIndices[1] + 1));
		
		return transactionAmount;
	}

}
