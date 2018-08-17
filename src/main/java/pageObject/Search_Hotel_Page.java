/**
 * 
 */
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

/**
 * @author Rajesh.Kumar4
 *
 */
public class Search_Hotel_Page {
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(Search_Hotel_Page.class);
	WaitHelper waitHelper;

	@FindBy(id = "autocomplete-location")
	public WebElement location;

	// Checkin Date Element
	@FindBy(className = "searchCheckIn")
	public WebElement check_InDropDown;
	@FindBy(className = "datepicker-switch")
	public WebElement selectcheckInMonthYear, selectcheckOutMonthYear;
	@FindBy(className = "next")
	public WebElement clickOnNext;
	@FindBy(xpath = "//td[@class='day']")
	public List<WebElement> selectChkInDay, selectChkOutDay;

	// CheckOut Date Element
	@FindBy(className = "searchCheckOut")
	public WebElement check_OutDropDown;
	// @FindBy(className = "datepicker-switch")
	// public WebElement selectcheckOutMonthYear;
	/*
	 * @FindBy(className = "next") public WebElement clickOnNext;
	 */
	// @FindBy(xpath = "//td[@class='day']")
	// public List<WebElement> selectChkOutDay;

	// Adult element
	@FindBy(xpath = "//div[@class='wrap-select-box wrap_select_box']")
	public WebElement adultDropdown;
	@FindBy(xpath = "//div[@class='select-dropdown-section']/span")
	public List<WebElement> ADULT;
		
	
	@FindBy(id = "listingPageBtn")
	public WebElement submitButton;

	public Search_Hotel_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, location, new Config(TestBase.OR).getExplicitWait());
	}

	public void enterLocation(String location) {
		log.info("Entering Destination Location..." + location);
		this.location.sendKeys(location);
	}

	public void selectCheckIn(String month_Year, String day) {
		log.info("Selecting Checkin Date...");
		this.check_InDropDown.click();
		while (!this.selectcheckInMonthYear.getText().contains(month_Year)) {
			this.clickOnNext.click();
		}
		System.out.println(this.selectChkInDay);
		List<WebElement> checkin_Day = this.selectChkInDay;
		for (WebElement chekin_D : checkin_Day) {
			String checkINday = chekin_D.getText();
			if (checkINday.equalsIgnoreCase(day)) {
				chekin_D.click();
				break;
			}
		}
	}

	public void selectCheckOut(String month_Year, String day) {
		log.info("Selecting Checkout Date...");
		this.check_OutDropDown.click();
		while (!this.selectcheckOutMonthYear.getText().contains(month_Year)) {
			this.clickOnNext.click();
		}
		System.out.println(this.selectChkOutDay);
		List<WebElement> checkout_Day = this.selectChkOutDay;
		for (WebElement chekout_D : checkout_Day) {
			String checkOUTday = chekout_D.getText();
			if (checkOUTday.equalsIgnoreCase(day)) {
				chekout_D.click();
				break;
			}
		}
	}

	public void selectAudult(String testAdult) {
		log.info("Selecting Adult...");
		this.adultDropdown.click();
		
		List<WebElement> adult = this.ADULT;
		for (WebElement adlt : adult) {
			String adultStr = adlt.getText();
			if (adultStr.equalsIgnoreCase(testAdult)) {
				adlt.click();
				break;
			}
		}
	}

	public Hotel_List_Page clickOnSubmitButton() {
		log.info("clickin on Submit Button and Redirecting to List Page...");
		this.submitButton.click();

		// driver.findElement(By.id("listingPageBtn")).click();
		return new Hotel_List_Page(driver);
	}

}
