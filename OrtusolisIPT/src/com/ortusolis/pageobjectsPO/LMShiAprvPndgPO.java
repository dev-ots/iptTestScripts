package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class LMShiAprvPndgPO extends TestBase
{
	By 
	USER_NAME,PASSWRD,SIGN_IN,Search_by,Shi_,EO_,Prt_,Knri_,
	SrhFld,Clk_Srh,Nw_Shi,Chng_Shi,Prg_Shi,PrtRcvd_Shi,Value;

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg1 = new JSONObject();
	public static JSONObject oJsTD_Reg1 = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void loadLMuserLocators() throws Exception
	{
		log.info("login as LM user");
		oJsOR_Reg1 = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_ShiAprvPdnLM.json");
		oJsTD_Reg1 = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_ShiAprvPdnLM.json");
	    oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir")+"/src/dataValidation/dataValidationShiAprvPdnLM.json");
		ShiAprvPdn(oJsOR_Reg1);
	}

	private void ShiAprvPdn(JSONObject oJsOR_Reg1) {
		
		USER_NAME= oSelUtil.loadWithBy(oJsOR_Reg1.getString("USER_NAME"));
		PASSWRD= oSelUtil.loadWithBy(oJsOR_Reg1.getString("PASSWRD"));
		SIGN_IN=oSelUtil.loadWithBy(oJsOR_Reg1.getString("SIGN_IN"));
		Search_by = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Search_by"));
		Shi_= oSelUtil.loadWithBy(oJsOR_Reg1.getString("Shi_"));
		EO_= oSelUtil.loadWithBy(oJsOR_Reg1.getString("EO_"));
		Prt_= oSelUtil.loadWithBy(oJsOR_Reg1.getString("Prt_"));
		Knri_= oSelUtil.loadWithBy(oJsOR_Reg1.getString("Knri_"));
		SrhFld= oSelUtil.loadWithBy(oJsOR_Reg1.getString("SrhFld"));
		Clk_Srh= oSelUtil.loadWithBy(oJsOR_Reg1.getString("Clk_Srh"));
		Nw_Shi= oSelUtil.loadWithBy(oJsOR_Reg1.getString("Nw_Shi"));
		Chng_Shi= oSelUtil.loadWithBy(oJsOR_Reg1.getString("Chng_Shi"));
		Prg_Shi= oSelUtil.loadWithBy(oJsOR_Reg1.getString("Prg_Shi"));
		PrtRcvd_Shi= oSelUtil.loadWithBy(oJsOR_Reg1.getString("PrtRcvd_Shi"));
		Value = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Value"));
}
	public boolean LoginLM_flow() throws Exception
	{
		boolean lmlogin_flag=false;
		try{
			oSelUtil.ufClear(driver, USER_NAME);
			oSelUtil.ufSendKeys(driver, USER_NAME, oJsTD_Reg1.getString("Userid"));
			oSelUtil.ufClear(driver, PASSWRD);
			oSelUtil.ufSendKeys(driver, PASSWRD, oJsTD_Reg1.getString("Pswd"));
			oSelUtil.ufClick(driver, SIGN_IN);
			oSelUtil.ufClick(driver, Search_by);
			oSelUtil.ufClick(driver, EO_);
			oSelUtil.ufSendKeys(driver, SrhFld, oJsTD_Reg1.getString("EO"));
			oSelUtil.ufClick(driver, Clk_Srh);
			
			
		
			
		}
		catch(Exception e)
		{
			log.info("Exception in login flow"+e);
			lmlogin_flag=false;
		}
		
		return lmlogin_flag;
		}
	
    public void NewShikesho()
    {
    	oSelUtil.ufClick(driver, Nw_Shi);
    	oSelUtil.ufIsDisplayed(driver, Value);
    	oSelUtil.ufClick(driver, Value);
    }
}
