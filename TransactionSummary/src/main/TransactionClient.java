package main;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.com.service.interfaces.TransactionSummaryService;
import main.com.util.FileUtility;

public class TransactionClient {
	
	private static ApplicationContext context;
	private static final String OUTPUTFILENAME = "Output.csv";
	
	public static void main(String... args) {
		PropertyConfigurator.configure("log4j.properties");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		TransactionSummaryService transactionSummaryService = (TransactionSummaryService) context.getBean("transactionSummary");
		FileUtility.printResultToCSV(transactionSummaryService.getTransactionSummary(), OUTPUTFILENAME);
	}
	
}
