package main.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtility {
	
	public static File getFileFromClasspath(String fileName) {
		ClassLoader classLoader = InputFileDescriptor.class.getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}
	
	public static String getFileContent(File file) {
		StringBuilder inputDescriptor = new StringBuilder("");
		try(Scanner scanner = new Scanner(file)) {
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				inputDescriptor.append(line).append("\n");
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return inputDescriptor.toString();
	}
}
