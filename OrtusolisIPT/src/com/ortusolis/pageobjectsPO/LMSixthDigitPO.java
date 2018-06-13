package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class LMSixthDigitPO extends TestBase
{
 By 
 Usr, Pwd, SignI, LogScr, SearchBy, Shi_, Knri_,
 SrhFld, Srh_Clk, Digit,Updt_Btn,Wrong_Digi_Msg;
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void LoadSixthDigitLocators() throws Exception
	{
		log.info("login as LM user update the Quantity, Delivery date ,Location and 6th digit");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_SixthDigit.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_SixthDigit.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationSixthDigit.json");
	  SixthDigitObjects(oJsOR_Reg);
	}

	private void SixthDigitObjects(JSONObject oJsOR_Reg)
	{
		Usr=oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr"));
		 Pwd = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd"));
		 SignI =oSelUtil.loadWithBy(oJsOR_Reg.getString("SignI"));
		 LogScr =oSelUtil.loadWithBy(oJsOR_Reg.getString("LogScr"));
		 SearchBy = oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy"));
		 Shi_ =oSelUtil.loadWithBy(oJsOR_Reg.getString("Shi_"));
		 Knri_ =oSelUtil.loadWithBy(oJsOR_Reg.getString("Knri"));
		 SrhFld = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhFld"));
		 Srh_Clk=oSelUtil.loadWithBy(oJsOR_Reg.getString("Srh_Clk"));
		 Digit = oSelUtil.loadWithBy(oJsOR_Reg.getString("Digit"));
		 Updt_Btn =oSelUtil.loadWithBy(oJsOR_Reg.getString("Updt_Btn"));
		 Wrong_Digi_Msg =oSelUtil.loadWithBy(oJsOR_Reg.getString("Wrong_Digi_Msg"));
	}
	
	public boolean SixthDigit() throws Exception
	{
		boolean sixth_dig= false;
		try
		{
			oSelUtil.ufClear(driver, Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("UserId"));
			oSelUtil.ufClear(driver, Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("Pwd"));
			oSelUtil.ufClick(driver, SignI);
			oSelUtil.ufGetTextValidation(driver, LogScr, oJsTD_Reg.getString("LogScr"));
			oSelUtil.ufClick(driver, SearchBy);
			oSelUtil.ufClick(driver, Shi_);
			oSelUtil.ufClear(driver, SrhFld);
			oSelUtil.ufSendKeys(driver, SrhFld, oJsTD_Reg.getString("SrhFldVal"));
			oSelUtil.ufClick(driver, Srh_Clk);
			oSelUtil.ufClear(driver, Digit);
			oSelUtil.ufGetTextValidation(driver, Digit, oJsTD_Reg.getString("Prt_Class1"));
			oSelUtil.ufClick(driver, Updt_Btn);
			
			
		}
		catch(Exception ew)
		{
		 log.info("Error in sixth digit"+ew);	
		 sixth_dig=false;
		}
		return sixth_dig;
	}
}
