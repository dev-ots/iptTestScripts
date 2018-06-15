package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.BOMusrAdmnScrPO;
import com.ortusolis.pageobjectsPO.LMloginPO;
import com.ortusolis.utilities.TestBase;

public class BOMusrAdmLogin extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	BOMusrAdmnScrPO bomUsrAdm= new BOMusrAdmnScrPO();
	String sTestCaseName="Login as BOM user and switch to BOM Admin";
	@Test
	public void BOMlogin() throws Exception
	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get("http://53.87.137.65:8080/ipt-app");
		bomUsrAdm.BOMusrLocators();
		bomUsrAdm.BOMlogin();
	}
	

}
