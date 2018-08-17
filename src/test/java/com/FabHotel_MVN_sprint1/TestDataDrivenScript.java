package com.FabHotel_MVN_sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.TestBase;

public class TestDataDrivenScript extends TestBase {
	@DataProvider(name="testData")
	public Object[][] dataSource(){
		return getData("TestData.xlsx", "Registration");		
	}
	@Test(dataProvider="testData")
	public void testLogin(String Var1,String Var2, String Var3, String Var4, String Var5, String Var6) {
		System.out.println(Var1);
		System.out.println(Var2);
		System.out.println(Var3);
		System.out.println(Var4);
		System.out.println(Var5);
		System.out.println(Var6);
	}
}
