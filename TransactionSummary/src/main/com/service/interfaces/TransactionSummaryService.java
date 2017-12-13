package main.com.service.interfaces;

import java.util.List;

public interface TransactionSummaryService {
	/*
	 * Builds a list of transaction summaries.
	 */
	public List<String> getTransactionSummary();
}
