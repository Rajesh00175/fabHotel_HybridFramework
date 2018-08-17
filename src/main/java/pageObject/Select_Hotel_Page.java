package pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.LoggerHelper;
import helper.WaitHelper;
import testBase.Config;
import testBase.TestBase;

public class Select_Hotel_Page {
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(Search_Hotel_Page.class);	
	WaitHelper waitHelper;
		
	@FindBy(xpath = "//h1[@class='title_wrapper']")
	public WebElement noOfHotelsonPage;
	@FindBy(xpath = "//div[@class='table-cell detail-wrap']/h3/a")
	public List<WebElement> hotelList;
	
	
	public Select_Hotel_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, noOfHotelsonPage, new Config(TestBase.OR).getExplicitWait());
	}
	
	public void selectHotel(String HNmae) {
		log.info("Selecting"+HNmae+" hotel from the list...");
		List<WebElement> bookHotel = this.hotelList;
		for (WebElement bookH : bookHotel) {
			String hName = bookH.getText();
			System.out.println(hName);
			if (hName.equalsIgnoreCase(HNmae)) { 

				// fabDriver.findElement(By.className("btn hotel-book-btn")).click();
				bookH.click();
				break;
			}
		}
	}
	
	
	
}
