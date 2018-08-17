/**
 * 
 */
package helper;


import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Rajesh.Kumar4
 *
 */
public class DropdownHelper {

	private WebDriver driver;
	private Logger Log = LoggerHelper.getLogger(DropdownHelper.class);

	public DropdownHelper(WebDriver driver) {
		this.driver = driver;
		Log.debug("DropDownHelper : " + this.driver.hashCode());
	}

	public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		Log.info("Locator : " + element + " Value : " + visibleValue);
	}

	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		Log.info("WebELement : " + element + " Value : " + value);
		return value;
	}

	public void SelectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		Log.info("Locator : " + element + " Value : " + index);
	}

	public void SelectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		Log.info("Locator : " + element + " Value : " + text);
	}

	public List<String> getAllDropDownValues(WebElement locator) {
		Select select = new Select(locator);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();

		for (WebElement element : elementList) {
			Log.info(element.getText());
			valueList.add(element.getText());
		}
		return valueList;
	}

	/*
	 * public void selectCheckinChechOutDate(String next, String yearmonth, String
	 * day, String dayDate) throws Exception { //public String next; String
	 * locatorYearMont = new Config(testbase.OR); while
	 * (!TestBase.getLocator(locatorYearMont).getText().contains(yearmonth)) {
	 * TestBase.getLocator(next).click(); }
	 * 
	 * @SuppressWarnings("unchecked") List<WebElement> element = (List<WebElement>)
	 * TestBase.getLocator(day); for (WebElement element_Day : element) { String
	 * checkINday = element_Day.getText(); if (checkINday.equalsIgnoreCase(dayDate))
	 * { element_Day.click(); break; } } }
	 */

	/*
	 * String inDate dd-MMM-yyyy (18-10-2018) String outDate
	 */
	
}
