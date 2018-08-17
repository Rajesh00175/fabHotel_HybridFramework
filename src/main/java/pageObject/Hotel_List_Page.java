/**
 * 
 */
package pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.LoggerHelper;
import helper.WaitHelper;
import testBase.Config;
import testBase.TestBase;

/**
 * @author Rajesh.Kumar4
 *
 */
public class Hotel_List_Page {
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(Search_Hotel_Page.class);	
	WaitHelper waitHelper;
		
	@FindBy(className = "title_wrapper")
	public WebElement noofHotels;
	
	//Test Filters
	@FindBy(className = "more-less-cities")
	public WebElement cityFilter;
	@FindBy(className = "locality-name")
	public WebElement selectCity;
	@FindBy(xpath = "//div[@id='policy_filter']/ul/li/label/div[@class='control__indicator']")
	public WebElement selectGuestPolicy;
	@FindBy(xpath = "//div[@id='max_guest_filter']/ul/li/label/div[@class='control__indicator']")
	public WebElement selectOccupancy;
	@FindBy(xpath = "//div[@id='room_amenities_filter']/ul/li/label/div[@class='control__indicator']")
	public WebElement selectAmenities;
	@FindBy(xpath = "//div[@class='selected-filters-list']/span")
	public List<WebElement> clearFilter;
	@FindBy(xpath = "//div[@class='selected-filters-list']/span[@id='clear_all']")
	public WebElement clearAllFilters;
	
	
	public Hotel_List_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver,noofHotels, new Config(TestBase.OR).getExplicitWait());
	}
	//Validate List page with count of Hotels
	public void validateHotelListPage() {
		log.info("Validating Hotel list Page" +noofHotels);
		String hotelNo = this.noofHotels.getText();
		System.out.println("No of Hotels"+hotelNo);
	}
	public void clickCityFilter() {
		log.info("Clicking more city link..." +cityFilter);
		this.cityFilter.click();
	}
	public void selectCityFilter() {
		log.info("Applying City Filter ..." +selectCity);
		this.selectCity.click();
	}
	public void selectGuestFilter() {
		log.info("Applying Guest Filter ..." +selectGuestPolicy);
		this.selectGuestPolicy.click();
	}
	public void selectOccupancyFilter() {
		log.info("Applying Occupancy Filter ..." +selectOccupancy);
		this.selectOccupancy.click();
	}
	public void selectAmenitiesFilter() {
		log.info("Applying Amenities Filter ..." +selectAmenities);
		this.selectAmenities.click();
	}
	public void clearFilter() {
		log.info("Clearing filters...");
		this.clearFilter.get(2).click();  ///for() loop required. Requires for() loop implementation.
	}
	public void clearAllFilters() {
		log.info("Clearing All filters..."+clearAllFilters);
		this.clearAllFilters.click();
	}
	public void scrollTOFilterElement() {
		log.info("Scrolling to the End of Filter Element..."+selectAmenities);
		JavascriptExecutor jsEXE = (JavascriptExecutor) driver;
		//jsEXE.executeScript("arguments[0].scrollIntoView();", selectAmenities);
		jsEXE.executeScript("window.scrollBy(0,500)");
	}
	public void scrollTOTop() {
		log.info("Scrooling to Top of page to clear filters...");
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		jsExe.executeScript("window.scrollBy(0,-500)");
	}
		
	
}
