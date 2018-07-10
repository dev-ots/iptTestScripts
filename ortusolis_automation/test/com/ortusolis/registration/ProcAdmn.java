package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.PROCUREMENTPO;
import com.ortusolis.pageobjectsPO.ProcAdmnPO;
import com.ortusolis.utilities.TestBase;

public class ProcAdmn  extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	ProcAdmnPO lml= new ProcAdmnPO();
	String sTestCaseName="Login as Procurement Admin landing screen will be displayed";
	PROCUREMENTPO ppo = new PROCUREMENTPO();
	@Test(priority=1)
	public void PrAdScr() throws Exception
	{
		log.info(oJsConfig.getString("IPT_PROC_ADMIN"));
		driver.get("http://53.87.137.65/proc_admin_home");
		lml.ProcAdmnlocators();
		lml.ProcAdActivities();
	}
	/*@Test(priority=2)
	public void ProcDetails() throws Exception
	{
		log.info(oJsConfig.getString("IPT_PROC_ADMIN"));
		driver.get("http://53.87.137.65/proc_admin_home");
		ppo.ProcusrLocators();
		ppo.SearchShikeisho();
		ppo.SelectSupplier();
		ppo.RFQ();*/
	
	
}

