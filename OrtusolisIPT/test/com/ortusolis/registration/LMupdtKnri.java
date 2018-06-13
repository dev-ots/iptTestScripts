package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.LMupdtKanriPO;
import com.ortusolis.utilities.TestBase;

public class LMupdtKnri  extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	LMupdtKanriPO Kpo= new LMupdtKanriPO();
	String sTestCase ="Updating location delivery date ,kanrino and quantity in LMuser Screen";
	@Test
	public void UpdatKnr() throws Exception
	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get("http://53.87.137.65:8080/ipt-app");
		Kpo.loadLMupdtKanriLocators();
		Kpo.UpdtKanr();
		driver.close();
		driver.get("http://53.87.137.65:8080/ipt-app");
		Kpo.UpdtKnrViewByRD();
		driver.close();
		driver.get("http://53.87.137.65:8080/ipt-app");
		Kpo.UpdtKnrViewByBOM();
		

		
	}
}
