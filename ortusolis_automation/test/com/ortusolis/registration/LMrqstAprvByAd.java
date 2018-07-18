package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ortusolis.pageobjectsPO.LMrqstAprvByAdmnPO;
import com.ortusolis.utilities.TestBase;

public class LMrqstAprvByAd extends TestBase {
	final Logger log = LoggerFactory.getLogger(getClass().getName());
	LMrqstAprvByAdmnPO lml = new LMrqstAprvByAdmnPO();
	String sTestCaseName_1 = "LM User Registration failure test case";
	String sTestCaseName_2 = "LM User Login failure";
	String sTestCaseName_3 = "Admin login failure test case";
	String sTestCaseName_4 = "Approving the User by Admin failure test case";
	String sTestCaseName_5 = "After Approve Login as LM User to Search Shikeisho failure test case";
	String sTestCaseName_6 = "Search Shikeisho failure test case";
	String sTestCaseName_7 = "Passing the LM Approve date,loaction and kanri failure test case";
	String sTestCaseName_8 = "";

	SoftAssert sa = new SoftAssert();

	@Test(priority = 2)
	public void LM_AdmnLog() throws Exception

	{
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml.AdmnLogn();
		boolean AdminLoginScreen = lml.AdmnLogn();
		sa.assertEquals(true, AdminLoginScreen, sTestCaseName_3);
		lml.LMUserApprovalByLMAdmin();
		boolean ApprovingUserByAdmin = lml.AdmnLogn();
		sa.assertEquals(true, ApprovingUserByAdmin, sTestCaseName_4);
		sa.assertAll();
	}

	@Test(priority = 1)
	public void LM_Usr_Rgstr() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml.RgstrLMUsr();
		boolean RegisterAsLMUser = lml.RgstrLMUsr();
		sa.assertEquals(true, RegisterAsLMUser, sTestCaseName_1);
		lml.UsrLogn();
		boolean LMUserLoginScreen = lml.UsrLogn();
		sa.assertEquals(true, LMUserLoginScreen, sTestCaseName_2);
		sa.assertAll();
	}

	@Test(priority = 3)
	public void UpdatingByLM() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		lml.UsrLogn();
		boolean LMUserLoginScreenTosearchShikeisho = lml.UsrLogn();
		sa.assertEquals(true, LMUserLoginScreenTosearchShikeisho, sTestCaseName_5);
		lml.ApproveShikeishoID();
		boolean SelectingShikeishoByLMuser = lml.AdmnLogn();
		sa.assertEquals(true, SelectingShikeishoByLMuser, sTestCaseName_6);
		Thread.sleep(2000);
		lml.UpdateVlues();
		boolean LMApprovedateLocationKanridigit = lml.AdmnLogn();
		sa.assertEquals(true, LMApprovedateLocationKanridigit, sTestCaseName_7);
		sa.assertAll();
	}

}
// lml.RgstrLMUsr();
// lml.UsrLogn();

/*
 * boolean bUserRegister=lml.RgstrLMUsr(); sa.assertEquals(true, bUserRegister,
 * "sTestCaseName_1"); lml.UsrLogn(); boolean bUserLogin= lml.UsrLogn();
 * sa.assertEquals(true, bUserLogin, "sTestCaseName_2"); lml.AdmnLogn(); boolean
 * bAdminLogin=lml.AdmnLogn(); sa.assertEquals(true, bAdminLogin,
 * "sTestCaseName_3"); Thread.sleep(5000); lml.UsrLogn(); sa.assertEquals(true,
 * bUserLogin, "sTestCaseName_2"); sa.assertAll();
 */

/*
 * @Test(priority=1) public void LM_AprvShikesho() throws Exception
 * 
 * { log.info(oJsConfig.getString("IPT_Login_URL"));
 * driver.get(oJsConfig.getString("IPT_Login_URL")); lml. RqstAprvLocators();
 * lml.UsrLogn(); boolean bAppReque= lml.ApproveShikeishoID(); SoftAssert sa =
 * new SoftAssert(); sa.assertEquals(true, bAppReque, sTestCaseName);
 * sa.assertAll(); }
 * 
 * @Test(priority=2) public void LM_UpdateValues() throws Exception
 * 
 * { log.info(oJsConfig.getString("IPT_Login_URL"));
 * driver.get(oJsConfig.getString("IPT_Login_URL"));
 * 
 * lml. RqstAprvLocators(); //lml.RgstrLMUsr(); lml.UsrLogn();
 * Thread.sleep(5000); lml.UpdtVlues(); }
 */
