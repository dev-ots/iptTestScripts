package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.LMLandingScrPO;
import com.ortusolis.utilities.TestBase;

public class LMlanding extends TestBase
{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	LMLandingScrPO lmldn= new LMLandingScrPO();
	
	@Test
	public void LM_landingPage() throws Exception
	{
		log.info(oJsConfig.getString("IPT_RD_LANDING"));
		driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING").toString());
		
		lmldn.lmPageLocators();
		lmldn.LMlandingScr();
		
	}

	
}
