package com.ortusolis.pageobjectsPO;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class LMLandingScrPO  extends TestBase
{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
    By User_Name,PasWd,sigNiN,Val_LMScr,SearchBy_Dropdown,SearchBy_Shikeisho,SearchBy_EO,SearchBy_kanri,SearchBy_Part,SearchBy_Text,New_Shikeisho,InProgress_Shikeisho,PartReceived_Shikeisho,
    SearchButton,Shikeisho_Number ,Desired_Date,Shikeisho_Status,Funding_Approval_Link;

    public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal =new JSONObject();
	
	
	public void lmPageLocators() throws Exception {
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_LMScreens.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_LMlandingscr.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.gir")+ "/src/dataValidation/dataValLMlndScr.json");
		lmPageObjects(oJsOR_Reg);
	}


	private void lmPageObjects(JSONObject oJsOR_Reg) throws Exception
	{
		User_Name=oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Name"));
		PasWd=oSelUtil.loadWithBy(oJsOR_Reg.getString("PasWd"));
		sigNiN=oSelUtil.loadWithBy(oJsOR_Reg.getString("sigNiN"));
		Val_LMScr=oSelUtil.loadWithBy(oJsOR_Reg.getString("Val_LMScr"));
		SearchBy_Dropdown=oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Dropdown"));
		SearchBy_Shikeisho=oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Shikeisho"));
		SearchBy_EO=oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_EO"));
		SearchBy_kanri=oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_kanri"));
		SearchBy_Part=oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Part"));
		SearchBy_Text=oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy_Text"));
		New_Shikeisho=oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shikeisho"));
		InProgress_Shikeisho=oSelUtil.loadWithBy(oJsOR_Reg.getString("InProgress_Shikeisho"));
		PartReceived_Shikeisho=oSelUtil.loadWithBy(oJsOR_Reg.getString("PartReceived_Shikeisho"));
		SearchButton=oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchButton"));
		Shikeisho_Number=oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number"));
		Shikeisho_Status=oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Status"));
		Funding_Approval_Link=oSelUtil.loadWithBy(oJsOR_Reg.getString("Funding_Approval_Link"));
		
		
	}
	
	public boolean LMlandingScr() throws Exception
	{
		boolean lnd_scr=false;
		try
		{
			oSelUtil.ufClear(driver, User_Name);
			oSelUtil.ufSendKeys(driver, User_Name, oJsTD_Reg.getString("User_id"));
			oSelUtil.ufClear(driver, PasWd);
			oSelUtil.ufSendKeys(driver, PasWd, oJsTD_Reg.getString("Pass_word"));
			oSelUtil.ufClick(driver, sigNiN);
			oSelUtil.ufGetTextValidation(driver, Val_LMScr, oJsDataVal.getString("LMlanding_screen") );
			 
			
		}
		catch(Exception ea) {
			log.info("Exception in login_flow : "+ea);
			lnd_scr=false;
		}
		return lnd_scr;
		
		
	}
	
}
