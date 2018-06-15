package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.TestBase;


public class SignInPO extends TestBase{
	
	By phone,email,password,agree,submit,F_Name,L_Name,cli_month,sel_month,
	cli_day,sel_day,cli_year,sel_year,zip,cli_favstore,sel_favstore,gender,almost_there,next_Step;
	
	By error_phone,error_mail,error_password,error_YesIAgree,
	error_FName,error_LName,error_BirthDate,error_zipcode,error_zipcode_NoStore,error_gender;
	
	By Sel_MonLeap,Sel_DayLeap,Sel_YearLeap,Sel_Bel18Mon,Sel_Bel18Day,Sel_Bel18Yea;
		
	String sPortalType;
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsTD_RegDOB = new JSONObject();
	
	JSONObject oJsOR_RegLoad = null; 
	JSONObject oJsTD_RegTypeVal = null;
	JSONObject oJsTD_RegError = null;
	public void loadRegistrationPageLocators(String sURL) throws Exception {
	
	log.info("loading locators as per reequirement");	
	sPortalType = oComUtil.getTypeOfPortal(sURL);
	oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_Registration.json");
	oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_Registration.json");
	oJsTD_RegDOB = oJsTD_Reg.getJSONObject("DOB");
	oJsTD_RegError = oJsTD_Reg.getJSONObject("error");
	
	if(sPortalType==null)
		throw new Exception(" Browser Type not detected..");
	else if(sPortalType.equals(Constants.sCustPortType_Generic))
	{
		oJsOR_RegLoad=oJsOR_Reg.getJSONObject(Constants.sCustPortType_Generic);
		oJsTD_RegTypeVal=oJsTD_Reg.getJSONObject(Constants.sCustPortType_Generic);
	}else if(sPortalType.equals(Constants.sCustPortType_Customized))
	{	oJsOR_RegLoad=oJsOR_Reg.getJSONObject(Constants.sCustPortType_Customized);
		oJsTD_RegTypeVal=oJsTD_Reg.getJSONObject(Constants.sCustPortType_Customized);
	}else if(sPortalType.equals(Constants.sCustPortType_Templeted))
	{	oJsOR_RegLoad=oJsOR_Reg.getJSONObject(Constants.sCustPortType_Templeted);
		oJsTD_RegTypeVal=oJsTD_Reg.getJSONObject(Constants.sCustPortType_Templeted);
	}else
	{
		log.error("Some thing went wrong while choosing Browser Type..\n Portal Type :: "+sPortalType);
		throw new Exception("Browser Type not handled correctly...");
	}
	loadingPageObjects(oJsOR_RegLoad);
	}
	
	/*
	 * Loading all the required objects by reading locators_registration
	 */
	
	private void loadingPageObjects(JSONObject oJsOR_RegLoad) throws Exception {
		
}
}
