/**
 * 
 */
package com.FabHotel_MVN_sprint1;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helper.LoggerHelper;
import pageObject.Home_Page;
import testBase.Config;
import testBase.TestBase;

/**
 * @author Rajesh.Kumar4
 *
 */
public class HomePageTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(HomePageTest.class);
	
	@Test
	public void testHomePage() {
		//TestBase testbase = new TestBase();
		log.info(HomePageTest.class.getName()+" started");
		Config config = new Config(OR);
		System.out.println("Website :++++  "+config.getWebsite());
		driver.get(config.getWebsite());				
		Home_Page homepage = new Home_Page(driver);
		
		homepage.clickOnLogo();
		//homepage.clickOnPhoneNo();
		homepage.clickCorporateEnquiry();
		homepage.quitCorporatePage();
	}
	
}
