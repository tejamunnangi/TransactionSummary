package main.com.util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtility {
	
    private static Logger logger = LoggerFactory.getLogger(FileUtility.class);
    
    //Get the file from the classpath. If the file is not present, throw exception.
	public static InputStream getFileFromClasspath(String fileName) throws FileNotFoundException {
		logger.debug("Trying to the file, "+fileName+" from the classpath");
		ClassLoader classLoader = InputFileDescriptor.class.getClassLoader();
		InputStream in = classLoader.getResourceAsStream(fileName);
		if(in == null) {
			throw new FileNotFoundException();
		}
		logger.debug("File, "+fileName+" is found and returned");
		return in;
		
	}
	
	public static String getFileContent(InputStream file) {
		StringBuilder inputDescriptor = new StringBuilder("");
		try(Scanner scanner = new Scanner(file)) {
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				inputDescriptor.append(line).append(Constants.NEW_LINE_SEPARATOR);
			}
			
			scanner.close();
		} 
		return inputDescriptor.toString();
	}
	
	public static void printResultToCSV(List<String> transactionSummary, String fileName) {
		logger.debug("Writing the output to the file, "+fileName);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.append(Constants.FILE_HEADER);
			fileWriter.append(Constants.NEW_LINE_SEPARATOR);
			for(String transactionSummaryRow : transactionSummary) {
				fileWriter.append(transactionSummaryRow);
				fileWriter.append(Constants.NEW_LINE_SEPARATOR);
			}
				
		} catch (IOException e) {
			logger.error("Ëxception occured while reading output file, "+fileName+":"+e);
		}
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				logger.error("Exception occured while flushing and closing the filewriter:"+e);
			}
		}
	}
}
