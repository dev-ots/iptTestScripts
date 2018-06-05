package com.ortusolis.registration;


import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.IPTLoginPO;
import com.ortusolis.pageobjectsPO.ForgotPwdPO;

import com.ortusolis.utilities.TestBase;

public class ForgotPassword extends TestBase
{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	ForgotPwdPO lpp = new ForgotPwdPO();
	String sTestCaseName="launch IPT continue for login";
	
	@Test
	public void IPT_User_Login() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.navigate().to(oJsConfig.getString("IPT_Login_URL").toString());
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("page load completed");
		lpp.LoginwithWrgPwd();
		lpp.ForgotPasswordIPT();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
}
}
