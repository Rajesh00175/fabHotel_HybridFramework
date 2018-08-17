package com.FabHotel_MVN_sprint1;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helper.LoggerHelper;
import pageObject.Hotel_List_Page;
import testBase.TestBase;
public class Hotel_ListPageTest {
	private final Logger log = LoggerHelper.getLogger(Hotel_ListPageTest.class);
	
	@Test
	public void TestFilter() {
		log.info(Hotel_ListPageTest.class.getName()+" started");
		Hotel_List_Page hotelListPage_filter = new Hotel_List_Page(TestBase.driver);
		hotelListPage_filter.validateHotelListPage();
		hotelListPage_filter.clickCityFilter();
		hotelListPage_filter.selectCityFilter();
		hotelListPage_filter.scrollTOFilterElement();
		hotelListPage_filter.selectGuestFilter();
		hotelListPage_filter.selectOccupancyFilter();
		hotelListPage_filter.selectAmenitiesFilter();
		hotelListPage_filter.scrollTOTop();
		hotelListPage_filter.clearFilter();
		hotelListPage_filter.clearAllFilters();		
		
	}
	@Test
	public void selectHotelFromList() {
		
	}

}
