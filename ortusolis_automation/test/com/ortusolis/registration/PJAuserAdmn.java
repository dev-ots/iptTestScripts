package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

//import com.ortusolis.pageobjectsPO.PJAUsrAdmnScr;
import com.ortusolis.pageobjectsPO.PJAUsrAdmnScrPO;
import com.ortusolis.utilities.TestBase;

public class PJAuserAdmn extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	PJAUsrAdmnScrPO pja=new PJAUsrAdmnScrPO();
	String sTestCaseName="Creating new PJA user and switch to admin ";
	@Test
	public void PjaUsr() throws Exception
	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get("http://53.87.137.65:8080/ipt-app");
		pja.PJAusrAdmnLocators();
		pja.RegPja_flow();
		pja.Swtch2Admn();
	}
		
	

}
