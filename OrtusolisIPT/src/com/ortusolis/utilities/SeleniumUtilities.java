package com.ortusolis.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paulhammant.ngwebdriver.ByAngular;

public class SeleniumUtilities extends TestBase{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	public By loadWithBy(String sReqlocator) {
		By objBy = null;
		String[] sArrLocaVal = oComUtil.ufSplitMe(sReqlocator);
		sArrLocaVal[0] = sArrLocaVal[0].toLowerCase();
	
		switch (sArrLocaVal[0])
		{
		case "model":
			objBy = ByAngular.model(sArrLocaVal[1]);
			break;
		case "repeater":
			objBy = ByAngular.repeater(sArrLocaVal[1]);
			break;
		case "id":
			objBy = By.id(sArrLocaVal[1]);
			break;
		case "button":
			log.info("****"+sArrLocaVal[0]);
			objBy = ByAngular.buttonText(sArrLocaVal[1]);
			break;
		case "xpath":
			objBy = By.xpath(sArrLocaVal[1]);
			break;
		case "class":
			objBy = By.className(sArrLocaVal[1]);
			break;
		case "partialLinkText":
			objBy = By.partialLinkText(sArrLocaVal[1]);
			break;
		case "css":
			objBy = By.cssSelector(sArrLocaVal[1]);
			break;
		
		default:
			log.error("Given locator is not available or Handled ");
			
		}
		
		return objBy;
	}

	
	public void ufSendKeys(WebDriver driver, By SelPageObj, String sValue) {
		driver.findElement(SelPageObj).clear();
		driver.findElement(SelPageObj).sendKeys(sValue);
	}

	public void ufClick(WebDriver driver, By SelPageObj) {
		driver.findElement(SelPageObj).click();		
	}
	
	public void ufClear(WebDriver driver, By SelPageObj) {
		driver.findElement(SelPageObj).clear();
	}
	
	public String ufGetText(WebDriver driver, By SelPageObj) {
		return driver.findElement(SelPageObj).getText();
	}
	public boolean ufIsDisplayed(WebDriver driver, By SelPageObj) {
		return driver.findElement(SelPageObj).isDisplayed();
	}

	public boolean ufIsSelected(WebDriver driver, By SelPageObj) {
		return driver.findElement(SelPageObj).isSelected();
	}
	public boolean ufIsEnabled(WebDriver driver, By SelPageObj) {
		return driver.findElement(SelPageObj).isEnabled();
	}

	public boolean ufGetTextValidation(WebDriver driver, By byPageObject, String sExpectedVal) {
		log.info("Actual : "+oSelUtil.ufGetText(driver, byPageObject)+"\nExpected: "+sExpectedVal);
		return oSelUtil.ufGetText(driver, byPageObject).contains(sExpectedVal);
	}
	
	public WebElement ufGetWebElement(WebDriver driver,By SelPageObject)
	{
		return driver.findElement(SelPageObject);
		
	}
}
