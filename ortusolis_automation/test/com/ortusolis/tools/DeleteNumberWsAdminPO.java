package com.ortusolis.tools;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.TestBase;
import com.paulhammant.ngwebdriver.ByAngular;


public class DeleteNumberWsAdminPO extends TestBase{
	
	By username,password,signin,support,mergeParent,selectPhoneOrEmail,phone,email,searchTerm,
	submitSearch,invalidEmailErrorText,errorDialog,AccountDetail,delete,deleteReasonId,TypographicalError,
	deleteUsername,deletePhone,DeleteButton,DeleteSuccess,logout;
		
	public static JSONObject oJsCo_Tools = new JSONObject();
	public static JSONObject oJsOR_tools = new JSONObject();
	public static JSONObject oJsOR_DelPhNum = new JSONObject();
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	public void loadRegistrationPageLocators() throws Exception {
		oJsCo_Tools = oJsConfig.getJSONObject("Tools");
		oJsOR_tools = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_tools.json");
		oJsOR_DelPhNum = oJsOR_tools.getJSONObject("WS_Admin");
	loadingPageObjects();
	}
	
	/*
	 * Loading all the required objects by reading locators_registration
	 */
	
	private void loadingPageObjects() throws Exception {
				
		username = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("username"));
		password = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("password"));
		signin = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("signin"));
		support = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("support"));
		mergeParent = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("mergeParent"));
		
		selectPhoneOrEmail = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("selectPhoneOrEmail"));
		phone = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("phone"));
		email = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("email"));
		searchTerm = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("searchTerm"));
		submitSearch = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("submitSearch"));
		invalidEmailErrorText = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("invalidEmailErrorText"));
		errorDialog = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("errorDialog"));
		AccountDetail = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("AccountDetail"));
		delete = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("delete"));
		deletePhone = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("deletePhone"));
		deleteReasonId = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("deleteReasonId"));
		deleteUsername = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("deleteUsername"));
		TypographicalError = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("TypographicalError"));
		DeleteButton = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("DeleteButton"));
		DeleteSuccess = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("DeleteSuccess"));
		logout = oSelUtil.loadWithBy(oJsOR_DelPhNum.getString("logout"));
		
	}

	public void ufDeletePhoneNumberOrEmail() throws Exception{
		driver.get(oJsCo_Tools.getString("URL_WS_Admin"));
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufSendKeys(driver, username, "spendgoadmin");
		oSelUtil.ufSendKeys(driver, password, "5kupedISready!");
		oSelUtil.ufClick(driver, signin);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufClick(driver, support);
		oSelUtil.ufClick(driver, mergeParent);
		Thread.sleep(2000);
		oSelUtil.ufClick(driver, selectPhoneOrEmail);
		if(oJsCo_Tools.getString("EmailOrPhoneNumber").contains("@"))
			oSelUtil.ufClick(driver, email);
		else
			oSelUtil.ufClick(driver, phone);
		
		oSelUtil.ufSendKeys(driver, searchTerm, oJsCo_Tools.getString("EmailOrPhoneNumber"));
		oSelUtil.ufClick(driver, submitSearch);
		ngWebDriver.waitForAngularRequestsToFinish();
		String sAccountDet=oSelUtil.ufGetText(driver, AccountDetail);
		String[] sArrAccountDet = sAccountDet.split(":");
		sAccountDet = sArrAccountDet[1].trim();
		log.info(sAccountDet);
		oSelUtil.ufClick(driver, delete);
		ngWebDriver.waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		oSelUtil.ufClick(driver, deleteReasonId);
		//oSelUtil.ufClick(driver, deleteReasonId);
		Thread.sleep(2000);
		oSelUtil.ufClick(driver, TypographicalError);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufSendKeys(driver, deleteUsername, sAccountDet);
		oSelUtil.ufSendKeys(driver, deletePhone, sAccountDet);
		//oSelUtil.ufClear(driver, DeleteButton);
		driver.findElement(ByAngular.buttonText("Delete")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		if(oSelUtil.ufGetTextValidation(driver, DeleteSuccess, "User successfully deleted."))
		{
			log.info("******************************************");
			log.info(oSelUtil.ufGetText(driver, DeleteSuccess));
			log.info("******************************************");
		}
		//Thread.sleep(5000);
	}
}
