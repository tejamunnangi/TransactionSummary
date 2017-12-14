package main.com.dao.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

public interface TransactionSummaryDAO {
	
	/*
	 * Extract transaction summary data from back-end.
	 */
	public List<String> getTransactionSummaryData() throws FileNotFoundException;
}
