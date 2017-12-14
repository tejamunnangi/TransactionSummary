package test.java.com.service.impl;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.com.beans.Client;
import main.com.service.interfaces.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("TestBeans.xml")
public class TestClientServiceImpl {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	Client clientInfo;
	
	@Test
	public void testGetClientInfo() throws FileNotFoundException {
		String transactionRow = "315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 "
				+ "0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     "
				+ "688032000092500000000             O";
		Assert.assertEquals(clientService.getClientInfo(transactionRow), "CL  432100020001");
	}
	
	@Test
	public void testBuildClientInfo() {
		String clientData = clientService.buildClientInfo(clientInfo);
		Assert.assertEquals(clientData, "CL  432100020001");
	}

}
