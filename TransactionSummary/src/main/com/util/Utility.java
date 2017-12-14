package main.com.util;


public class Utility {
	
	public static int[] getStartEndIndices(String locationString) {
		String[] splitLocation = locationString.split("-");
		int[] locationIndices = new int[2];
		locationIndices[0] = Integer.valueOf(splitLocation[0]);
		locationIndices[1] = Integer.valueOf(splitLocation[1]);
		return locationIndices;
	}
	
	public static String removeTrailingZeros(String stringWithTrailingZeros) {
		String stringWithoutTrailingZeros = "";
		for(int i = 0; i < stringWithTrailingZeros.length(); i++) {
			if(stringWithTrailingZeros.charAt(i) != '0') {
				stringWithoutTrailingZeros = stringWithTrailingZeros.substring(i);
				break;
			}
			//Oh, the irony! if all the string has is 0's, return 0.
			else {
				stringWithoutTrailingZeros = "0";
			}
		}
		return stringWithoutTrailingZeros;
	}
}
