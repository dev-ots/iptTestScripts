package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.RDLandingScreenPO;
import com.ortusolis.utilities.TestBase;

public class RDLanding extends TestBase{
	
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	RDLandingScreenPO rdLandingScreenPO = new RDLandingScreenPO();
	String sTestCaseName="RD user landing page to view shikeisho in IPT system";
	
	@Test
	public void RD_SearchPage() throws Exception
	{
		log.info(oJsConfig.getString("IPT_RD_LANDING"));
		driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING").toString());
		ngWebDriver.waitForAngularRequestsToFinish();
		
		rdLandingScreenPO.loadRegistrationPageLocators();
		rdLandingScreenPO.search_ShikeishoDetails();
		
	}


}
