package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class BOMusrAdmnScrPO extends TestBase 
{
	By User_Id,PassWd,signIn,Usr_Scr,UserPro_Disp,Srh_Disp,NewShi_Disp,ChngShi_Disp,PrgShi_Disp,
		 RcvdShi_Disp,User_Proile,Switch_Admin,Admin_Scr;

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void BOMusrLocators() throws Exception
	{
		log.info("login as LM user");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_BOMloginScr.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_BOMlogin.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationBOMlogin.json");
	    
		BOMloginpageobjects(oJsOR_Reg);
	}

	private void BOMloginpageobjects(JSONObject oJsOR_Reg) 
	{
		User_Id = oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Id"));
		PassWd = oSelUtil.loadWithBy(oJsOR_Reg.getString("PassWd"));
	    signIn = oSelUtil.loadWithBy(oJsOR_Reg.getString("signIn"));
	    Usr_Scr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_Scr"));
	    UserPro_Disp = oSelUtil.loadWithBy(oJsOR_Reg.getString("UserPro_Disp"));
	    Srh_Disp =oSelUtil.loadWithBy(oJsOR_Reg.getString("Srh_Disp"));
	    NewShi_Disp = oSelUtil.loadWithBy(oJsOR_Reg.getString("NewShi_Disp"));
	    ChngShi_Disp = oSelUtil.loadWithBy(oJsOR_Reg.getString("ChngShi_Disp"));
	    PrgShi_Disp = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrgShi_Disp"));
	    RcvdShi_Disp = oSelUtil.loadWithBy(oJsOR_Reg.getString("RcvdShi_Disp"));
	    User_Proile =oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Proile"));
	    Switch_Admin = oSelUtil.loadWithBy(oJsOR_Reg.getString("Switch_Admin"));
	    Admin_Scr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Admin_Scr"));
	    
	}
	public boolean BOMlogin() throws Exception
	{
		boolean BOM_login=false;
		try
		{
			oSelUtil.ufClear(driver, User_Id);
			oSelUtil.ufSendKeys(driver, User_Id,oJsTD_Reg.getString("User_ID") );
			oSelUtil.ufClear(driver, PassWd);
			oSelUtil.ufSendKeys(driver, PassWd, oJsTD_Reg.getString("PassWord") );
			oSelUtil.ufClick(driver, signIn);
			oSelUtil.ufGetTextValidation(driver, Usr_Scr, oJsDataVal.getString("BOMusr_lndgScr"));
			oSelUtil.ufIsDisplayed(driver, UserPro_Disp);
			oSelUtil.ufIsDisplayed(driver, Srh_Disp);
			oSelUtil.ufIsDisplayed(driver, NewShi_Disp);
			oSelUtil.ufIsDisplayed(driver, ChngShi_Disp);
			oSelUtil.ufIsDisplayed(driver, PrgShi_Disp);
			oSelUtil.ufIsDisplayed(driver, RcvdShi_Disp);
			oSelUtil.ufClick(driver, User_Proile);
			oSelUtil.ufClick(driver, Switch_Admin);
			oSelUtil.ufGetTextValidation(driver, Admin_Scr, oJsDataVal.getString("BOM_Admn_Scr"));
			
			
			
		}
		catch(Exception ex)
		{
			log.info("Login error in BOM page"+ex);
			BOM_login = false;
		}
		return BOM_login;
		
	}

	}
