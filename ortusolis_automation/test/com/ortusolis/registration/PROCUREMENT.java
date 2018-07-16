package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.PROCUREMENTPO;
import com.ortusolis.utilities.TestBase;

public class PROCUREMENT extends TestBase {
	PROCUREMENTPO ppo = new PROCUREMENTPO();
	final Logger log = LoggerFactory.getLogger(getClass().getName());

	@Test
	public void login() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		ppo.ProcusrLocators();
		ppo.ProcAdminLogin();
		ppo.SearchShikeisho();
		ppo.SelectSupplier();
		Thread.sleep(2000);
		ppo.RFQ();
		// ppo.selectlanguage();

	}
}
