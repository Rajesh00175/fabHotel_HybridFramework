/**
 * 
 */
package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.AlertHelper;
import helper.LoggerHelper;
import helper.WaitHelper;
import testBase.Config;
import testBase.TestBase;

/**
 * @author Rajesh.Kumar4
 *
 */
public class Home_Page {
	WebDriver driver;
	WaitHelper waitHelper;
	private final Logger log = LoggerHelper.getLogger(Home_Page.class);
	TestBase testbase = new TestBase();
	
	@FindBy(className="logo")
	public WebElement Logo;
	@FindBy(xpath="//span[@class='call-section clearfix call_us']/a")
	public WebElement PhoneNo;
	@FindBy(xpath="//a[contains(@title,'Corporate Enquiries')]")
	public WebElement CorporateEnq;
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);		
		waitHelper.waitForElement(driver, Logo, new Config(TestBase.OR).getExplicitWait());
	}
	
	public void clickOnLogo() {		
		Logo.click();
		log.info("FabHotel Home Page Clicked");
	}
	
	public void clickOnPhoneNo() {
		log.info("FabHotel Contact No.");
		PhoneNo.click();
		AlertHelper alert = new AlertHelper(driver);
		alert.AcceptAlert();
	}
	//Close all tab except original tab
	public void quitCorporatePage() {
		log.info("Quiting Enquary page tab...");
		String originalHandle = driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
		}
		driver.switchTo().window(originalHandle);
	}
	
	public Corporate_Enq_Page clickCorporateEnquiry() {
		log.info("Clicking on Corporate Enquiry Link");
		CorporateEnq.click();
		return new Corporate_Enq_Page();
	}
	
}
