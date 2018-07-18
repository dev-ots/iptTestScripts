package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ortusolis.pageobjectsPO.BOMPO;
import com.ortusolis.pageobjectsPO.LMrqstAprvByAdmnPO;
import com.ortusolis.utilities.TestBase;

public class BOM extends TestBase {

	final Logger log = LoggerFactory.getLogger(getClass().getName());
	BOMPO bp = new BOMPO();
	String sTestCaseName_2 = "User Registration failure test case";
	String sTestCaseName_3 = "User Login failure test case";
	String sTestCaseName_4 = "Admin Login failure test case";
	String sTestCaseName_5 = "Approving User by Admin failure test case";
	String sTestCaseName_6 = "User fails to login test case";
	String sTestCaseName_7 = "User Detail landing Screen failure test case";
	String sTestCaseName_8 = "Bom User Searching the Shikeisho Screen failure test case";
	String sTestCaseName_9 = "Assigning the BOM User for Shikeisho parts failure test case";
	String sTestCaseName_10 = "Changing the quantity, deleivery date and assigning buyer group failure test case";
	String sTestCaseName_11 = "Login as LM User failure test case";
	String sTestCaseName_12 = "LM approving the shikeisho failure test case";
	String sTestCaseName_13 = "Logout as LM User Failure test case";
	String sTestCaseName_14 = "";

	SoftAssert sa = new SoftAssert();

	@Test(priority = 1)
	public void BOM_RGSTR() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMusrLocators();
		bp.RgstrBOMUsr();
		boolean BomUserRegistration = bp.RgstrBOMUsr();
		sa.assertEquals(true, BomUserRegistration, sTestCaseName_2);
		sa.assertAll();
	}

	@Test(priority = 2)
	public void BOM_USR_LOG() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMlogin();
		boolean BomUserLogin = bp.BOMlogin();
		sa.assertEquals(true, BomUserLogin, sTestCaseName_3);
		sa.assertAll();
	}

	@Test(priority = 3)
	public void BOM_AD_LOG() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMADMINlogin();
		boolean BOmAdminLogin = bp.BOMADMINlogin();
		sa.assertEquals(true, BOmAdminLogin, sTestCaseName_4);
		bp.AdminAproveUser();
		boolean ApprovingRegisteredUser = bp.AdminAproveUser();
		sa.assertEquals(true, ApprovingRegisteredUser, sTestCaseName_5);
		Thread.sleep(3000);
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMlogin();
		boolean LoginAfterApprove = bp.BOMlogin();
		sa.assertEquals(true, LoginAfterApprove, sTestCaseName_6);
		sa.assertAll();
	}

	@Test(priority = 4)
	public void AssignBOMUser() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMlogin1();
		boolean BomAdminDetailScreen = bp.BOMlogin1();
		sa.assertEquals(true, BomAdminDetailScreen, sTestCaseName_7);
		bp.SearchShikeisho();
		boolean BomUserSearchShikeisho = bp.SearchShikeisho();
		sa.assertEquals(true, BomUserSearchShikeisho, sTestCaseName_8);

		bp.AssignBOMUserforLMAprvShi();
		boolean AssigningTheBomUser = bp.AssignBOMUserforLMAprvShi();
		sa.assertEquals(true, AssigningTheBomUser, sTestCaseName_9);

		bp.VerifyChangedVAlues();
		boolean QuantityandDeliveryDatesByBomUser = bp.VerifyChangedVAlues();
		sa.assertEquals(true, QuantityandDeliveryDatesByBomUser, sTestCaseName_10);
		sa.assertAll();
	}

	@Test(priority = 5)
	public void LMviewAfterBOMChangedShikeisho() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		LMrqstAprvByAdmnPO laba = new LMrqstAprvByAdmnPO();
		laba.UsrLognToApproveChangedShikeisho();
		boolean LoginAsLMUsertoApproveChangedValuesByBOM = laba.UsrLognToApproveChangedShikeisho();
		sa.assertEquals(true, LoginAsLMUsertoApproveChangedValuesByBOM, sTestCaseName_11);

		laba.ViewvingBOMChangedShikeishoByLM();
		boolean ApprovingTheChangedQuantityByLM = laba.ViewvingBOMChangedShikeishoByLM();
		sa.assertEquals(true, ApprovingTheChangedQuantityByLM, sTestCaseName_12);

		laba.LMUserLogout();
		boolean AfterApprovingLMUserlogout = laba.LMUserLogout();
		sa.assertEquals(true, AfterApprovingLMUserlogout, sTestCaseName_13);
		sa.assertAll();
	}

}
