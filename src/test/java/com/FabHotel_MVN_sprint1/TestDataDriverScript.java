package com.FabHotel_MVN_sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.TestBase;

public class TestDataDriverScript extends TestBase {
	
	@DataProvider(name="testData")
	public Object[][] dataSource(){
		return getData("TestData.xlsx", "LoginTestData");		
	}
	@Test(dataProvider="testData")
	public void testLogin(String username,String password, String runmode) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(runmode);
	}
	
}
