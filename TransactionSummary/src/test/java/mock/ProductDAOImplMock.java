package test.java.mock;

import java.io.FileNotFoundException;

import main.com.beans.Product;
import main.com.dao.interfaces.ProductDAO;
import main.com.util.InputFileDescriptor;
import main.com.util.Utility;

public class ProductDAOImplMock implements ProductDAO {

	@Override
	public Product getProductData(String transactionRow) throws FileNotFoundException {
		int[] locationIndices = new int[2];
		Product productInfo = new Product();
		
		String exchangeCodeLocation = InputFileDescriptor.getExchangeCodeLocation();
		locationIndices = Utility.getStartEndIndices(exchangeCodeLocation);
		String exchangeCode = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setExchangeCode(exchangeCode);
		
		String productGroupNumberLocation = InputFileDescriptor.getProductGroupCodeLocation();
		locationIndices = Utility.getStartEndIndices(productGroupNumberLocation);
		String productGroupNumber = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setProdGroupCode(productGroupNumber);
		
		String symbolLocation = InputFileDescriptor.getSymbolLocation();
		locationIndices = Utility.getStartEndIndices(symbolLocation);
		String symbol = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setSymbol(symbol);
		
		String exchangeDateLocation = InputFileDescriptor.getExchangeDateLocation();
		locationIndices = Utility.getStartEndIndices(exchangeDateLocation);
		String exchangeDate = transactionRow.substring(locationIndices[0] - 1, locationIndices[1]);
		productInfo.setExchangeDate(exchangeDate);
		
		return productInfo;
	}

}
