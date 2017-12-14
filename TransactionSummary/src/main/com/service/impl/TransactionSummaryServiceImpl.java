package main.com.service.impl;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.com.dao.interfaces.TransactionSummaryDAO;
import main.com.service.interfaces.TransactionSummaryService;

public class TransactionSummaryServiceImpl implements TransactionSummaryService {
	
	@Autowired
	TransactionSummaryDAO transactinSummaryDAO;

	@Override
	public List<String> getTransactionSummary() throws FileNotFoundException {
		List<String> transactionSummary = transactinSummaryDAO.getTransactionSummaryData();
		return transactionSummary;
	}

}
