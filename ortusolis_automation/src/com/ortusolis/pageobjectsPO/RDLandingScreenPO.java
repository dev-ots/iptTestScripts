package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class RDLandingScreenPO extends TestBase {

final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	By User_Name, Switch_Admin_Role,SearchBy_Dropdown,SearchBy_Shikeisho,SearchBy_EO,SearchBy_kanri,	SearchBy_Part,
	SearchBy_Text,New_Shikeisho,funding_Link,New_Shikeisho_App_Count, funding_close,InProgress_Shikeisho,PartReceived_Shikeisho,SearchButton,
	Shikeisho_Number,Desired_Date,Shikeisho_Status,Funding_Approval_Link;
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	
	
	public void loadRegistrationPageLocators() throws Exception {
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_RDLanding.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_RDScreens.json");
		loadingPageObjects(oJsOR_Reg);
	}
	private void loadingPageObjects(JSONObject oJsOR_Reg) throws Exception {
		User_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Name"));
		Switch_Admin_Role =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Switch_Admin_Role"));
		SearchBy_Dropdown =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Dropdown"));
		SearchBy_Shikeisho =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Shikeisho"));
		SearchBy_EO =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_EO"));
		SearchBy_kanri =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_kanri"));
		SearchBy_Part =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Part"));
		SearchBy_Text =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Text"));
		New_Shikeisho =  oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shikeisho"));
		InProgress_Shikeisho =  oSelUtil.loadWithBy(oJsOR_Reg.getString("InProgress_Shikeisho"));
		PartReceived_Shikeisho =  oSelUtil.loadWithBy(oJsOR_Reg.getString("PartReceived_Shikeisho"));
		SearchButton =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchButton"));
		Shikeisho_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number"));
		Desired_Date =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Desired_Date"));
		Shikeisho_Status =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Status"));
		Funding_Approval_Link =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Funding_Approval_Link"));
		New_Shikeisho =oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shikeisho"));
		funding_Link =oSelUtil.loadWithBy(oJsOR_Reg.getString("funding_Link"));
		funding_close= oSelUtil.loadWithBy(oJsOR_Reg.getString("funding_close"));
		New_Shikeisho_App_Count= oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shikeisho_App_Count"));
}
	
	public boolean search_ShikeishoDetails() throws Exception{
		boolean bRes_flag=false;
		try {
		oSelUtil.ufClear(driver, SearchBy_Text);
		System.out.println("Before click on the dropdown");
		oSelUtil.ufClick(driver, SearchBy_Dropdown);
		System.out.println("After click on to the dropdown");
		
		oSelUtil.ufClick(driver,SearchBy_EO);
		oSelUtil.ufSendKeys(driver, SearchBy_Text, oJsTD_Reg.getString("SearchBy_Value"));
		oSelUtil.ufClick(driver, SearchButton);
		if(oSelUtil.ufIsDisplayed(driver, New_Shikeisho_App_Count)) {
			oSelUtil.ufClick(driver, New_Shikeisho);

			//oSelUtil.ufClick(driver,funding_Link);
			//oSelUtil.ufClick(driver, funding_close);
			
			Thread.sleep(3000);
			
			oSelUtil.ufClick(driver, User_Name);
			//ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, Switch_Admin_Role);
			
		}
		
		
		
	/*	if(oSelUtil.ufIsSelected(driver, SearchBy_EO)) {
			System.out.println("Inside the if");
			oSelUtil.ufSendKeys(driver, SearchBy_Text, oJsTD_Reg.getString("shno1"));
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}*/
	/*if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("SearchBy_Shikeisho") ) {
			oSelUtil.ufSendKeys(driver, SearchBy_Text, oJsTD_Reg.getString("TP1234"));
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}*/
		/*else if(oSelect.equals("SearchBy_kanri")) 
		{
			oSelUtil.ufSendKeys(driver, SearchBy_Text, "12345");
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}
		else if(oSelect.equals("SearchBy_EO"))
		{
			oSelUtil.ufSendKeys(driver, SearchBy_Text, "12345");
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}
		*/
		
		}catch(Exception ea) {
			log.info("Exception in login_flow : "+ea);
			bRes_flag=false;
		}
		return bRes_flag;
		
	}
	
	public boolean switchRoleToAdmin() {
		boolean bRes_flag = false;
		
		try
		{
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, User_Name);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, Switch_Admin_Role);
			bRes_flag= true;
		}
		catch(Exception ea)
		{
			bRes_flag= false;
		}
		
		return bRes_flag;
	}
}
