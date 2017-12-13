package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.com.service.interfaces.TransactionSummaryService;
import main.com.util.Constants;

public class TransactionClient {
	
	private static ApplicationContext context;
	private static final String OUTPUTFILENAME = "Output.csv";
	
	public static void main(String... args) {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		TransactionSummaryService transactionSummaryService = (TransactionSummaryService) context.getBean("transactionSummary");
		printResultToCSV(transactionSummaryService.getTransactionSummary());
	}
	
	private static void printResultToCSV(List<String> transactionSummary) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(OUTPUTFILENAME);
			fileWriter.append(Constants.FILE_HEADER);
			
			for(String transactionSummaryRow : transactionSummary) {
				fileWriter.append(transactionSummaryRow);
				fileWriter.append(Constants.NEW_LINE_SEPARATOR);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
