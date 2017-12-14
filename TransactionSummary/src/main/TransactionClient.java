package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.com.service.interfaces.TransactionSummaryService;
import main.com.util.FileUtility;

public class TransactionClient {
	
	private static ApplicationContext context;
	private static final String OUTPUTFILENAME = "Output.csv";
	
	public static void main(String... args) throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("log4j.properties"));
		PropertyConfigurator.configure(props);
		context = new ClassPathXmlApplicationContext("Beans.xml");
		TransactionSummaryService transactionSummaryService = (TransactionSummaryService) context.getBean("transactionSummary");
		try {
			FileUtility.printResultToCSV(transactionSummaryService.getTransactionSummary(), OUTPUTFILENAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
