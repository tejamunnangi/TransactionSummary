package com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class InputFileDescriptor {
	public static final String INPUTDESCFILE = "InputDescriptor.txt";
	public static String CLIENTTYPELOCATION;
	private static Scanner descriptorFile;
	private static Scanner getDescriptorFile(){
		try {
			if(descriptorFile != null) {
				descriptorFile = new Scanner(new FileReader("filename.txt"));
			}
			return descriptorFile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public String getClientTypeLocation() {
		CLIENTTYPELOCATION = getValueFromFile("clientType");
		return null;
	}
	private String getValueFromFile(String string) {
		getDescriptorFile().next();
		return null;
	}
}
