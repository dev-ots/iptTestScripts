package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ortusolis.pageobjectsPO.LMrqstAprvByAdmnPO;
import com.ortusolis.utilities.TestBase;

public class LMrqstAprvByAd extends TestBase
{
final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	LMrqstAprvByAdmnPO lml= new LMrqstAprvByAdmnPO();
	String sTestCaseName_1="LM User Registration failure test case";
	String sTestCaseName_2="LM User Login failure";
	String sTestCaseName_3="Admin login failure test case";
	String sTestCaseName_4= "User login failure test case";
			
	
	@Test(priority=3)
	public void LM_AdmnLog() throws Exception

	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml. RqstAprvLocators();
		lml.AdmnLogn();
		
		lml.LMUserApprovalByLMAdmin();
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml.UsrLogn();
	}
	@Test(priority=1)
	public void LM_Usr_Rgstr() throws Exception
	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml. RqstAprvLocators();
		lml.RgstrLMUsr();
		
	}	
	@Test(priority=2)
	public void LM_Usr_Login() throws Exception
	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml. RqstAprvLocators();
		lml.UsrLogn();
	}
	@Test(priority=4)
	public void UpdatingByLM() throws Exception
	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml.UsrLogn();
		lml.ApproveShikeishoID();
		Thread.sleep(2000);
		lml.UpdateVlues();
	}
	
}	
		//lml.RgstrLMUsr();
		//lml.UsrLogn();
		
		/*boolean bUserRegister=lml.RgstrLMUsr();
		sa.assertEquals(true, bUserRegister, "sTestCaseName_1");
		lml.UsrLogn();
		boolean bUserLogin= lml.UsrLogn();
		sa.assertEquals(true, bUserLogin, "sTestCaseName_2");
		lml.AdmnLogn();
		boolean bAdminLogin=lml.AdmnLogn();
		sa.assertEquals(true, bAdminLogin, "sTestCaseName_3");
		Thread.sleep(5000);
		lml.UsrLogn();
		sa.assertEquals(true, bUserLogin, "sTestCaseName_2");
		sa.assertAll();*/
	
	/*@Test(priority=1)
	public void LM_AprvShikesho() throws Exception

	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml. RqstAprvLocators();
		lml.UsrLogn();
		boolean bAppReque= lml.ApproveShikeishoID();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(true, bAppReque, sTestCaseName);
		sa.assertAll();
	}
	
	@Test(priority=2)
	public void LM_UpdateValues() throws Exception

	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		
		lml. RqstAprvLocators();
		//lml.RgstrLMUsr();
		lml.UsrLogn();
		Thread.sleep(5000);
		lml.UpdtVlues();
	}*/


