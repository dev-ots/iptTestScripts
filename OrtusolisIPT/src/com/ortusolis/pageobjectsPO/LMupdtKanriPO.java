package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class LMupdtKanriPO extends TestBase 
{
 By Usr, Pwd, SignI,Log_Sucs,Logout,UsrProfile, SearchBy, Shi_, Knri_,EO,PrtNo, SrhFld, Srh_Clk, LOc, DlvrDt,
 Quant, Digit, Sv_Updt_Btn,Updated_Msg, RD_usr_LndngScr,BOM_usr_LndngScr;


	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void loadLMupdtKanriLocators() throws Exception
	{
		log.info("login as LM user update the Quantity, Delivery date ,Location and 6th digit");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_LMupdtKanri.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_LMupdtKanri.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationLMupdtKanri.json");
		
		LMupdtKanriPageObjects(oJsOR_Reg);
	    

	}

	private void LMupdtKanriPageObjects(JSONObject oJsOR_Reg)
	{
	 Usr=oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr"));
	 Pwd = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd"));
	 SignI =oSelUtil.loadWithBy(oJsOR_Reg.getString("SignI"));
	 Log_Sucs =oSelUtil.loadWithBy(oJsOR_Reg.getString("Log_Sucs"));
	 UsrProfile =oSelUtil.loadWithBy(oJsOR_Reg.getString("UsrProfile"));
	 Logout =oSelUtil.loadWithBy(oJsOR_Reg.getString("Logout"));
	 SearchBy = oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy"));
	 Shi_ =oSelUtil.loadWithBy(oJsOR_Reg.getString("Shi_"));
	 Knri_ =oSelUtil.loadWithBy(oJsOR_Reg.getString("Knri"));
	 EO =oSelUtil.loadWithBy(oJsOR_Reg.getString("EO"));
	 PrtNo=oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtNo"));
	 SrhFld = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhFld"));
	 Srh_Clk=oSelUtil.loadWithBy(oJsOR_Reg.getString("Srh_Clk"));
	 LOc=oSelUtil.loadWithBy(oJsOR_Reg.getString("LOc"));
	 DlvrDt=oSelUtil.loadWithBy(oJsOR_Reg.getString("DlvrDt"));
	 Quant=oSelUtil.loadWithBy(oJsOR_Reg.getString("Quant"));
	 Digit=oSelUtil.loadWithBy(oJsOR_Reg.getString("Digit"));
	 Sv_Updt_Btn = oSelUtil.loadWithBy(oJsOR_Reg.getString("Sv_Updt_Btn"));
	 Updated_Msg =oSelUtil.loadWithBy(oJsOR_Reg.getString("Updated_Msg"));
	 RD_usr_LndngScr =oSelUtil.loadWithBy(oJsOR_Reg.getString("RD_usr_LndngScr"));
	 BOM_usr_LndngScr = oSelUtil.loadWithBy(oJsOR_Reg.getString("BOM_usr_LndngScr"));
	}
	
	public boolean UpdtKanr() throws Exception
	{ 
	
		boolean updt_Kanr=false;
		try
		{
			oSelUtil.ufClear(driver, Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("UserId"));
			oSelUtil.ufClear(driver, Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("Pwd"));
			oSelUtil.ufClick(driver, SignI);
			oSelUtil.ufGetTextValidation(driver, Log_Sucs, oJsTD_Reg.getString("Log_Sucs"));
			oSelUtil.ufClick(driver, SearchBy);
			oSelUtil.ufClick(driver, Shi_);
			oSelUtil.ufClear(driver, SrhFld);
			oSelUtil.ufSendKeys(driver, SrhFld, oJsTD_Reg.getString("SrhFldVal"));
			oSelUtil.ufClick(driver, Srh_Clk);
			oSelUtil.ufClear(driver, LOc);
			oSelUtil.ufSendKeys(driver, LOc, oJsTD_Reg.getString("Loc"));
			oSelUtil.ufClear(driver, DlvrDt);
			oSelUtil.ufSendKeys(driver, DlvrDt, oJsTD_Reg.getString("DlvrDt"));
			oSelUtil.ufClear(driver, Digit);
			oSelUtil.ufSendKeys(driver, Digit, oJsTD_Reg.getString("6thDigi"));
			oSelUtil.ufClear(driver, Quant);
			oSelUtil.ufSendKeys(driver, Quant, oJsTD_Reg.getString("Quan"));
			oSelUtil.ufClick(driver, Sv_Updt_Btn);
			oSelUtil.ufGetTextValidation(driver, Updated_Msg, oJsTD_Reg.getString("Updt_Sucs"));
			oSelUtil.ufClick(driver, UsrProfile);
			oSelUtil.ufClick(driver, Logout);
		}
		catch(Exception ee)
		{
			log.info("Error in updating the kanri "+ee);
	         updt_Kanr=false;
		}
		return updt_Kanr;
	}
	
	public boolean UpdtKnrViewByRD() throws Exception
	{
	   boolean KnrViewRD= false;
	   try
	   {
		   oSelUtil.ufClear(driver, Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("RDuser"));
			oSelUtil.ufClear(driver, Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("RDPwd"));
			oSelUtil.ufClick(driver, SignI);
			oSelUtil.ufGetTextValidation(driver, RD_usr_LndngScr, oJsDataVal.getString("RD_usr_LndngScr"));
			oSelUtil.ufClick(driver, SearchBy);
			oSelUtil.ufClick(driver, Shi_);
			oSelUtil.ufClear(driver, SrhFld);
			oSelUtil.ufSendKeys(driver, SrhFld, oJsTD_Reg.getString("SrhFldVal"));
			oSelUtil.ufClick(driver, Srh_Clk);
			oSelUtil.ufClick(driver, UsrProfile);
			oSelUtil.ufClick(driver, Logout);
					
	   }
	   catch(Exception e)
	   {
		   log.info("Error in viewing updated kanri by RD user"+e);
		   KnrViewRD=false;
	   }
	return KnrViewRD;
	}
	
	public boolean UpdtKnrViewByBOM() throws Exception
	{
		boolean KnrViewBOM =false;
		try
		{
			oSelUtil.ufClear(driver, Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("BOMuser"));
			oSelUtil.ufClear(driver, Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("BOMPwd"));
			oSelUtil.ufClick(driver, SignI);
			oSelUtil.ufGetTextValidation(driver, BOM_usr_LndngScr, oJsDataVal.getString("BOM_usr_LndngScr"));
			oSelUtil.ufClick(driver, SearchBy);
			oSelUtil.ufClick(driver, Shi_);
			oSelUtil.ufClear(driver, SrhFld);
			oSelUtil.ufSendKeys(driver, SrhFld, oJsTD_Reg.getString("SrhFldVal"));
			oSelUtil.ufClick(driver, Srh_Clk);
			oSelUtil.ufClick(driver, UsrProfile);
			oSelUtil.ufClick(driver, Logout);
			
		}
		catch(Exception ex)
		{
			log.info("Error in viewing updated kanri by RD user"+ex);
		}
		return KnrViewBOM;
		
	}
	}
	

