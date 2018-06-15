package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.LMloginPO;
import com.ortusolis.pageobjectsPO.LMrqstAprvByAdmnPO;
import com.ortusolis.utilities.TestBase;

public class LMrqstAprvByAd extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	LMrqstAprvByAdmnPO lml= new LMrqstAprvByAdmnPO();
	String sTestCaseName="Launch IPT URL in chrome and Enter the LM Admin details to register in IPT system";
	@Test
	public void LM_AdmnLog() throws Exception

	{
		log.info(oJsConfig.getString("URL_IPT_APP"));
		driver.get("http://53.87.137.65/login");
		lml. RqstAprvLocators();
		lml.RgstrLMUsr();
		lml.UsrLogn();
		Thread.sleep(5000);
		lml.AdmnLogn();
		Thread.sleep(5000);
		lml.UsrLogn();
	}
	@Test
	public void LM_AprvShikesho() throws Exception

	{
		log.info(oJsConfig.getString("URL_IPT_APP"));
		driver.get("http://53.87.137.65/login");
		//lml. RqstAprvLocators();
		lml.RgstrLMUsr();
		lml.ApproveShikeishoID();
	}
	
	@Test
	public void LM_UpdateValues() throws Exception

	{
		log.info(oJsConfig.getString("URL_IPT_APP"));
		driver.get("http://53.87.137.65/login");
		lml. RqstAprvLocators();
		//lml.RgstrLMUsr();
		lml.UsrLogn();
		Thread.sleep(5000);
		lml.UpdtVlues();
	}


}
