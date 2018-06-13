package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.RDDetailsPO;
import com.ortusolis.pageobjectsPO.RDLandingScreenPO;
import com.ortusolis.utilities.TestBase;

public class RDDetailsValidation extends TestBase{
	
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	RDDetailsPO rdDetailsPO = new RDDetailsPO();
	String sTestCaseName="RD user landing page to view shikeisho in IPT system";
	
	@Test
	public void RD_SearchPage() throws Exception
	{
		log.info(oJsConfig.getString("IPT_RD_DETAILS"));
		driver.navigate().to(oJsConfig.getString("IPT_RD_DETAILS".toString()));
		ngWebDriver.waitForAngularRequestsToFinish();
		
		rdDetailsPO.loadRDDetailsPO();
		boolean rd_flag = rdDetailsPO.rdDetailsValidate();
		
	}

}
