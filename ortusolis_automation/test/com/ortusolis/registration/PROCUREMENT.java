package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ortusolis.pageobjectsPO.PROCUREMENTPO;
import com.ortusolis.utilities.TestBase;

public class PROCUREMENT extends TestBase {
	PROCUREMENTPO ppo = new PROCUREMENTPO();
	final Logger log = LoggerFactory.getLogger(getClass().getName());
	String sTestCaseName_1 = "User Registration failure test case";

	SoftAssert sa = new SoftAssert();

	@Test
	public void login() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		ppo.ProcusrLocators();
		ppo.ProcUserLogin();
		ppo.SearchShikeisho();
		ppo.SelectSupplier();
		Thread.sleep(2000);
		ppo.RFQ();
		// ppo.selectlanguage();
	}

	public void Details() throws Exception {
		ppo.AddBuyerInBuyerGroupSection();
		ppo.NewAssistant();
		ppo.NewBuyer();
		ppo.NewBuyerGroup();
		ppo.UserApprovalByAdmin();
		ppo.UpdateRoleByAdmin();
		ppo.UnitPrice_Cost();

	}

	@Test
	public void RegisterPROCUser() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		ppo.RegisterAsProcUser();
		boolean RegistrationAsProcUser = ppo.RegisterAsProcUser();
		sa.assertNotEquals(true, RegistrationAsProcUser, sTestCaseName_1);

	}
}
