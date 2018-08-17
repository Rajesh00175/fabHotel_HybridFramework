/**
 * 
 */
package com.FabHotel_MVN_sprint1;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helper.LoggerHelper;
import pageObject.Search_Hotel_Page;
import testBase.Config;
import testBase.TestBase;

/**
 * @author Rajesh.Kumar4
 *
 */
public class Search_HotelTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(Search_HotelTest.class);
	
	@Test
	public void SearchHotel() {
		log.info(Search_HotelTest.class.getName()+" started");
		Config config = new Config(OR);
		System.out.println("Website :++++  "+config.getWebsite());
		String destLoc =  config.getDesination_location();
		String CheckInDate = config.getCheckin();
		String[] splitCIN = CheckInDate.split("-");
		String cinDay = splitCIN[0];
		String cinMnYr = splitCIN[1];
		String CheckOutDate = config.getCheckout();
		String[] splitCOUT = CheckOutDate.split("-");
		String coutDay = splitCOUT[0];
		String coutMnYr = splitCOUT[1];
		String Adult = config.getAdult();
		
		System.out.println("CIN Day :"+cinDay);
		System.out.println("CIN Month Year :"+cinMnYr);
		driver.get(config.getWebsite());				
		Search_Hotel_Page searchHotelPage = new Search_Hotel_Page(driver);
		searchHotelPage.enterLocation(destLoc);
		searchHotelPage.selectCheckIn(cinMnYr,cinDay);
		searchHotelPage.selectCheckOut(coutMnYr, coutDay);
		searchHotelPage.selectAudult(Adult);
		searchHotelPage.clickOnSubmitButton();
		
	}
}
