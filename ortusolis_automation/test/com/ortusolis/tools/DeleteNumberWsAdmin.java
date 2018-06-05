package com.ortusolis.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.utilities.TestBase;

public class DeleteNumberWsAdmin extends TestBase{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	DeleteNumberWsAdminPO delNumPh = new DeleteNumberWsAdminPO(); 
	@Test
	public void deletePhoneNumberTool() throws Exception{
		delNumPh.loadRegistrationPageLocators();
		delNumPh.ufDeletePhoneNumberOrEmail();
	}

}
