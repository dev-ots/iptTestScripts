package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.UsrRgstrByAdmnPO;
import com.ortusolis.utilities.TestBase;

public class UsrRgstrByAdmn extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	 UsrRgstrByAdmnPO urba = new  UsrRgstrByAdmnPO();
	String sTestCaseName="Admin Register the new user";
	@Test
	public void NewUsrByAd() throws Exception
	{

		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get("http://53.87.137.65:8080/ipt-app");
		urba.NewUsrByAdmnlocators();
		urba.NewUsrRgstr();
		
	}
	
	

}
