
package com.ortusolis.registration;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.IPTLoginPO;
import com.ortusolis.pageobjectsPO.LoginPagePO;

import com.ortusolis.utilities.TestBase;

public class IPTUserLogin extends TestBase
{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	IPTLoginPO lpp = new IPTLoginPO();
	String sTestCaseName="launch IPT continue for login";
	
	@Test
	public void IPT_User_Login() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.navigate().to(oJsConfig.getString("IPT_Login_URL").toString());
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("page load completed");
		lpp.loadLoginPageLOcators();
		lpp.login_flowIPT();
		System.out.println("11111");
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
}
}
