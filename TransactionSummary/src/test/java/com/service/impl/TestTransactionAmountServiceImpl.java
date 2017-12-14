package test.java.com.service.impl;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.com.beans.TransactionAmount;
import main.com.service.interfaces.TransactionAmountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:TestBeans.xml")
public class TestTransactionAmountServiceImpl {

	
	@Autowired
	TransactionAmountService transactionAmountService;
	
	@Autowired
	TransactionAmount transactionAmountInfo;
	
	@Test
	public void testGetTransactionAmountInfo() throws FileNotFoundException {
		String transactionRow = "315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 "
				+ "0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     "
				+ "688032000092500000000             O";
		Assert.assertEquals(transactionAmountService.getTransactionAmountInfo(transactionRow), "9.249999991E10");
	}
	
	@Test
	public void testBuildTransactionAmountInfo() {
		String transactionAmountData = transactionAmountService.buildTransactionAmountInfo(transactionAmountInfo);
		Assert.assertEquals(transactionAmountData, "9.249999991E10");
	}


}
