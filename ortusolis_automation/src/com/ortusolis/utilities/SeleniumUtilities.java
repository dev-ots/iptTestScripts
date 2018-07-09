package com.ortusolis.utilities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class SeleniumUtilities extends TestBase {
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

	public By loadWithBy(String sReqlocator) {
		By objBy = null;
		String[] sArrLocaVal = oComUtil.ufSplitMe(sReqlocator);
		sArrLocaVal[0] = sArrLocaVal[0].toLowerCase();

		switch (sArrLocaVal[0]) {
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
			log.info("****" + sArrLocaVal[0]);
			objBy = ByAngular.buttonText(sArrLocaVal[1]);
			break;
		case "xpath":
			objBy = By.xpath(sArrLocaVal[1]);
			break;
		case "class":
			objBy = By.className(sArrLocaVal[1]);
			// objBy = ByClassName.className(sArrLocaVal[1]);
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

	public void ufSendKeys(NgWebDriver driver, By SelPageObj, String sValue) {
		((WebDriver) driver).findElement(SelPageObj).clear();
		((WebDriver) driver).findElement(SelPageObj).sendKeys(sValue);
	}

	public void ufClick(WebDriver driver, By SelPageObj) {
		driver.findElement(SelPageObj).click();
	}

	public void ufClick(NgWebDriver driver, By SelPageObj) {
		((WebDriver) driver).findElement(SelPageObj).click();
	}

	public void ufClear(WebDriver driver, By SelPageObj) {
		driver.findElement(SelPageObj).clear();
	}

	public void ufClear(NgWebDriver driver, By SelPageObj) {
		((WebDriver) driver).findElement(SelPageObj).clear();

	}

	public String ufGetText(WebDriver driver, By SelPageObj) {
		return driver.findElement(SelPageObj).getText();
	}

	public boolean ufIsDisplayed(WebDriver driver, By SelPageObj) {
		boolean bRes_Flag=true;
		try {
			System.out.println("111111111111");
			System.out.println(driver.findElement(SelPageObj).isDisplayed());
			bRes_Flag=true;
		}catch(Exception ufDisplay)
			{bRes_Flag=false;}
		return bRes_Flag;
	}

	public boolean ufIsSelected(WebDriver driver, By SelPageObj) {
		return driver.findElement(SelPageObj).isSelected();
	}

	public boolean ufIsEnabled(WebDriver driver, By SelPageObj) {
		return driver.findElement(SelPageObj).isEnabled();
	}

	public boolean ufGetTextValidation(WebDriver driver, By byPageObject, String sExpectedVal) {
		log.info("Actual : " + oSelUtil.ufGetText(driver, byPageObject) + "\nExpected: " + sExpectedVal);
		return oSelUtil.ufGetText(driver, byPageObject).contains(sExpectedVal);
	}

	public String ufGetText(NgWebDriver driver, By SelPageObj) {
		return ((WebDriver) driver).findElement(SelPageObj).getText();
	}

	public boolean ufIsDisplayed(NgWebDriver driver, By SelPageObj) {
		return ((WebDriver) driver).findElement(SelPageObj).isDisplayed();
	}

	public boolean ufIsSelected(NgWebDriver driver, By SelPageObj) {
		return ((WebDriver) driver).findElement(SelPageObj).isSelected();
	}

	public boolean ufIsEnabled(NgWebDriver driver, By SelPageObj) {
		return ((WebDriver) driver).findElement(SelPageObj).isEnabled();
	}

	public boolean ufGetTextValidation(NgWebDriver driver, By byPageObject, String sExpectedVal) {
		log.info("Actual : " + oSelUtil.ufGetText(driver, byPageObject) + "\nExpected: " + sExpectedVal);
		return oSelUtil.ufGetText(driver, byPageObject).contains(sExpectedVal);
	}

	public boolean ufWaitForElementVisible(NgWebDriver driver, By byPageObject, int iSeconds) throws Exception {
		int iSecCount = 0;
		boolean bRes_Flag=false;
		if (iSeconds * 2 != iSecCount) {
			if (!ufIsDisplayed(driver, byPageObject)) {
				Thread.sleep(500);
				iSecCount = +1;
			}else
			{
				bRes_Flag=true;
				log.info("Element displayed in  : "+ iSecCount);
				return bRes_Flag;
			}
		}
		
		return bRes_Flag;
	}
	
	public boolean ufWaitForElementVisible(WebDriver driver, By byPageObject, int iSeconds) throws Exception {
		int iSecCount = 0;
		boolean bRes_Flag=false;
		int expectedWait=(iSeconds*2); 
		System.out.println(expectedWait);
		
		if ( expectedWait != iSecCount) {
		System.out.println(expectedWait +"::"+iSecCount);
			if (!ufIsDisplayed(driver, byPageObject)) {
				log.info("Count : "+iSecCount);
				Thread.sleep(500);
				iSecCount = iSecCount+1;
			}else
			{
				bRes_Flag=true;
				log.info("Element displayed in  : "+ iSecCount);
				return bRes_Flag;
			}
		}
		
		return bRes_Flag;
	}

	public WebElement ufGetWebElement(NgWebDriver driver, By SelPageObj) {
		return ((WebDriver) driver).findElement(SelPageObj);
	}

	public List<WebElement> ufGetWebElements(NgWebDriver driver, By SelPageObj) {
		return (List<WebElement>) ((WebDriver) driver).findElements(SelPageObj);
	}

	public List<WebElement> ufGetWebElements(WebDriver driver, By SelPageObj) {
		return (List<WebElement>) driver.findElements(SelPageObj);
	}

	public int getIndexOfMatchingTextWebElements(List<WebElement> eleList, String strTextMatching) {

		for (int i = 0; i < eleList.size(); i++) {
			if (eleList.get(i).getText().contains(strTextMatching))
				return i;
		}
		return 0;
	}

	public void AlertHandling(NgWebDriver ngWebDriver) {
		Alert alt = driver.switchTo().alert();
		//String USER_APPROVED = alt.getText();
		alt.accept();
		ngWebDriver.waitForAngularRequestsToFinish();
	}

}
