package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.RegistrationPO;
import com.ortusolis.utilities.TestBase;

public class CCA_005 extends TestBase {

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	String sTestCaseName="\"Phone number validation on sign up page\r\n" + 
			"1. Empty Phone number\r\n" + 
			"2. Below and above 10 digit \r\n" + 
			"3. Should check phone number already registered\r\n" + 
			"4. Should auto format \r\n" + 
			"5. String and Special charachters shouldnot allow\"";
	String sURL;
	
	@Parameters({ "URL_Type"})
	@BeforeTest
	public void getURLSettingEnvironment(String sURL_Type) throws Exception{
		sErrorMessage="";
		sURL = oJsConfig.get(sURL_Type).toString();
		sURL=oComUtil.setEnvironment(sURL);
		log.info(sURL);
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		poReg.loadRegistrationPageLocators(sURL);
	}
	
	@Test
	public void CCA_004_WhenEmptyAllShouldPopulate() throws Exception {	
		poReg.ufWhenAllEmptyFieldError(sURL);
	}
}
