package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


import com.ortusolis.pageobjectsPO.ProcAdmnPO;
import com.ortusolis.utilities.TestBase;

public class ProcAdmn  extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	ProcAdmnPO lml= new ProcAdmnPO();
	String sTestCaseName="Login as Procurement Admin landing screen will be displayed";
	@Test
	public void PrAdScr() throws Exception
	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get("http://53.87.137.65:8080/ipt-app");
		lml.ProcAdmnlocators();
		lml.ProcAdmnlogin();
	}
	

}
