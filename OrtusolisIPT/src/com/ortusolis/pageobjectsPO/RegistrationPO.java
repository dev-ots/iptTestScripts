package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.TestBase;


public class RegistrationPO extends TestBase{
	
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
		try {
		phone = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("Phone"));
		email = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("Email"));
		password = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("password"));
		agree = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("agree"));
		submit = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("submit"));
		F_Name = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("F_Name"));
		L_Name = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("L_Name"));
		
		cli_month = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("cli_month"));
		sel_month = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_month").replace("monthVal", oJsTD_RegDOB.getString("MM")));
		Sel_MonLeap = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_month").replace("monthVal", "3"));//3 is February here
		Sel_Bel18Mon = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_month").replace("monthVal", "10"));
		
		cli_day = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("cli_day"));
		sel_day = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_day").replace("dateval", oJsTD_RegDOB.getString("DD")));
		Sel_DayLeap = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_day").replace("dateval", "30"));//30 is 29th on date.. Indexing problem
		Sel_Bel18Day = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_day").replace("dateval", "10"));
		
		cli_year = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("cli_year"));
		sel_year = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_year").replace("yearVal", oJsTD_RegDOB.getString("YY")));
		Sel_YearLeap = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_year").replace("yearVal", "1991"));
		Sel_Bel18Yea = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_year").replace("yearVal", "2004"));
		
		zip  = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("zip"));
		cli_favstore  = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("cli_favstore"));
		sel_favstore  = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("sel_favstore"));
		if(oJsTD_RegTypeVal.getString("Gender").toLowerCase().contains("male"))		
			gender  = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("gen_male"));
		else
			gender  = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("gen_femail"));
		}catch (Exception na) {
			log.error("Problem while loadingObject(JSONObject oJsOR_RegLoad) function..");
		}
		almost_there = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("almost_there"));
		next_Step = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("next_Step"));
		
		error_phone = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_phone"));
		error_mail = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_mail"));
		error_password = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_password"));
		error_YesIAgree = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_YesIAgree"));
		//error_FName,error_LName,,,;
		error_FName = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_FName"));
		error_LName = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_LName"));
		error_BirthDate = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_BirthDate"));
		error_zipcode = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_zipcode"));
		error_zipcode_NoStore = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_zipcode_NoStore"));
		error_gender = oSelUtil.loadWithBy(oJsOR_RegLoad.getString("error_gender"));
		
}

	/* Fill all datas on registration page and do complete registration flow
	 * validation = Almost there text
	*/
	public boolean ufFillData_CompleteRegistrationFlow() throws Exception{
		boolean bRes_flag = false;
		
		oSelUtil.ufSendKeys(driver,phone, oJsTD_RegTypeVal.getString("Phone"));
		oSelUtil.ufSendKeys(driver, email, oJsTD_RegTypeVal.getString("Email"));
		oSelUtil.ufSendKeys(driver, password, oJsTD_Reg.getString("Password"));
		if(sPortalType.equals(Constants.sCustPortType_Generic))
		{
			oSelUtil.ufSendKeys(driver, F_Name, oJsTD_Reg.getString("F_Name"));
			oSelUtil.ufSendKeys(driver, L_Name, oJsTD_Reg.getString("L_Name"));
			oSelUtil.ufClick(driver, cli_month);
			oSelUtil.ufClick(driver, sel_month);
			oSelUtil.ufClick(driver, cli_day);
			oSelUtil.ufClick(driver, sel_day);
			oSelUtil.ufClick(driver, cli_year);
			oSelUtil.ufClick(driver, sel_year);
			oSelUtil.ufClick(driver, gender);
			oSelUtil.ufSendKeys(driver, zip, oJsTD_Reg.getString("zip_code"));
			oSelUtil.ufClick(driver, cli_favstore);
			Thread.sleep(1000);
			oSelUtil.ufClick(driver, sel_favstore);
			oSelUtil.ufClick(driver, submit);
			ngWebDriver.waitForAngularRequestsToFinish();
		}else if(sPortalType.equals(Constants.sCustPortType_Customized))
		{	
			oSelUtil.ufClick(driver,agree);
			oSelUtil.ufClick(driver, next_Step);
			ngWebDriver.waitForAngularRequestsToFinish();
			if(!oSelUtil.ufIsDisplayed(driver, F_Name))
				return false;
			oSelUtil.ufSendKeys(driver, F_Name, oJsTD_Reg.getString("F_Name"));
			oSelUtil.ufSendKeys(driver, L_Name, oJsTD_Reg.getString("L_Name"));
			oSelUtil.ufClick(driver, cli_month);
			oSelUtil.ufClick(driver, sel_month);
			oSelUtil.ufClick(driver, cli_day);
			oSelUtil.ufClick(driver, sel_day);
			oSelUtil.ufClick(driver, cli_year);
			oSelUtil.ufClick(driver, sel_year);
			oSelUtil.ufSendKeys(driver, zip, oJsTD_Reg.getString("zip_code"));
			oSelUtil.ufClick(driver, cli_favstore);
			Thread.sleep(1000);
			oSelUtil.ufClick(driver, sel_favstore);
			oSelUtil.ufClick(driver, gender);
			oSelUtil.ufClick(driver, submit);
			ngWebDriver.waitForAngularRequestsToFinish();
			
		}else if(sPortalType.equals(Constants.sCustPortType_Templeted))
		{	
			oSelUtil.ufSendKeys(driver, F_Name, oJsTD_Reg.getString("F_Name"));
			oSelUtil.ufClick(driver, cli_month);
			oSelUtil.ufClick(driver, sel_month);
			oSelUtil.ufClick(driver, cli_day);
			oSelUtil.ufClick(driver, sel_day);
			oSelUtil.ufClick(driver, cli_year);
			oSelUtil.ufClick(driver, sel_year);
			oSelUtil.ufClick(driver, submit);
			ngWebDriver.waitForAngularRequestsToFinish();
		}
		
		if((oSelUtil.ufGetText(driver, almost_there)).contains(Constants.sAlmostThere))
			bRes_flag=true;
		else
		{
		log.error("Actual : "+Constants.sAlmostThere+"\nExpected : "+oSelUtil.ufGetText(driver, almost_there));
		return bRes_flag =false;
		}
	log.info("Actual : "+Constants.sAlmostThere+"\nExpected : "+oSelUtil.ufGetText(driver, almost_there));
		
	
	return bRes_flag;
	}
	/*
	 * checking phone number related errors here
	 * "Phone number validation on sign up page
1. Empty Phone number
2. Below and above 10 digit 
3. Should check phone number already registered
4. Should auto format  ---> cannot validate
5. String and Special charachters shouldnot allow --> blind validation can be done but not handled
	 */
	
	public boolean ufPhoneNumberErrorChecks(String sURL) throws Exception{
		boolean bRes_flag=false;
		boolean bEmptyPhone=true,bBelowTenNum=true,bAlreadyReg=true;
		oSelUtil.ufClick(driver, submit);
		ngWebDriver.waitForAngularRequestsToFinish();
		
		if(!oSelUtil.ufGetTextValidation(driver,error_phone,oJsDataVal.getString("error_phone_empty")))
		{
			bEmptyPhone=false;
			sErrorMessage=sErrorMessage+",error_phone_empty validation fail";
		}
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufSendKeys(driver, phone, oJsTD_RegError.getString("error_phone_belowTen"));
		oSelUtil.ufClick(driver, email);
		ngWebDriver.waitForAngularRequestsToFinish();
		//Thread.sleep(3000);
		if(!oSelUtil.ufGetTextValidation(driver, error_phone,oJsDataVal.getString("error_phone_belowTen")))
		{
			bBelowTenNum=false;
			sErrorMessage= sErrorMessage + ",error_phone_belowTen validation fail";
		}	
		
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufSendKeys(driver, phone, oJsTD_RegError.getString("error_phone_alreadyRegistered"));
		oSelUtil.ufClick(driver, email);
		ngWebDriver.waitForAngularRequestsToFinish();
		//Thread.sleep(3000);
		if(!oSelUtil.ufGetTextValidation(driver, error_phone,oJsDataVal.getString("error_phone_alreadyRegistered")))
		{
			bBelowTenNum=false;
			sErrorMessage = sErrorMessage+",error_phone_alreadyRegistered validation fail";
		}	
			bAlreadyReg=true;
		
		if(bEmptyPhone && bBelowTenNum && bAlreadyReg)
			bRes_flag=true;
		else
			throw new Exception (sErrorMessage);
		return bRes_flag;
	}
	/*
	 * checking below errors here
	 * "Email validation on Sign Up page
1. just alphabet
2.Only _ and . should accept rest all should through error --- Not handled
3. without .com 
4. Check email which is already registered
5. empty " 
	 */

	public boolean ufEmailErrorChecks(String sURL) throws Exception {
		boolean bRes_Flag=false,bEmptyEmail=true,bRegistered=true,binvalid=true,bOnlyAlpha=true;
			
			driver.get(sURL);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, submit);
			ngWebDriver.waitForAngularRequestsToFinish();
			Thread.sleep(1000);
			if(!oSelUtil.ufGetTextValidation(driver,error_mail,oJsDataVal.getString("error_email_empty")))
			{
				bEmptyEmail=false;
				sErrorMessage =sErrorMessage+"problem in email empty error validation";
			}
			driver.get(sURL);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, email, oJsTD_RegError.getString("error_email_invalidEmail"));
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, password);
			
			Thread.sleep(1000);
			if(!oSelUtil.ufGetTextValidation(driver,error_mail,oJsDataVal.getString("error_email_invalidEmail")))
			{
				bRegistered=false;
				sErrorMessage =sErrorMessage+"problem in error_email_invalidEmail validation";
			}
			
			driver.get(sURL);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, email, oJsTD_RegError.getString("error_email_alreadyRegistered"));
			oSelUtil.ufClick(driver, password);
			ngWebDriver.waitForAngularRequestsToFinish();
			Thread.sleep(1000);
			
			if(!oSelUtil.ufGetTextValidation(driver,error_mail,oJsDataVal.getString("error_email_alreadyRegistered")))
			{
				binvalid=false;
				sErrorMessage =sErrorMessage+"problem in error_email_alreadyRegistered validation";
			}
			
		
			driver.get(sURL);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, email, oJsTD_RegError.getString("error_email_onlyAlpahabet"));
			oSelUtil.ufClick(driver, password);
			ngWebDriver.waitForAngularRequestsToFinish();
			Thread.sleep(1000);
			if(!oSelUtil.ufGetTextValidation(driver,error_mail,oJsDataVal.getString("error_email_onlyAlpahabet")))
			{
				bOnlyAlpha=false;
				sErrorMessage =sErrorMessage+"problem in error_email_onlyAlpahabet validation";
			}
			
			if(bEmptyEmail && bRegistered && binvalid && bOnlyAlpha)
				bRes_Flag=true;
			else
			{
				log.info("Logging :: "+sErrorMessage);
				throw new Exception(sErrorMessage);
			}
		return bRes_Flag;
	}

	/* checking all password related error checks
	 * "Password validation on signup page
1. Must be greater than 6 letters --> produced by giving less than 6
2. must be less than 15 letters  --> produced by giving more than 15
3. empty password"
	 * 	 */
	
	public boolean ufPasswordErrorChecks(String sURL) throws Exception {
		boolean bRes_Flag=false,bBelowSix=true,bAboveFifteen=true,bEmpty=true;
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufClick(driver, password);
		oSelUtil.ufClick(driver, email);
		ngWebDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		if(!oSelUtil.ufGetTextValidation(driver,error_password,oJsDataVal.getString("error_password")))
		{
			bEmpty=false;
			sErrorMessage =sErrorMessage+"problem in password empty error validation";
		}
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufSendKeys(driver, password, oJsTD_RegError.getString("error_password_belowSix"));
		oSelUtil.ufClick(driver, email);
		ngWebDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		if(!oSelUtil.ufGetTextValidation(driver,error_password,oJsDataVal.getString("error_password_belowSix")))
		{
			bBelowSix=false;
			sErrorMessage =sErrorMessage+"problem in error_password_belowSix validation";
		}
		
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufSendKeys(driver, password, oJsTD_RegError.getString("error_password_aboveFifteen"));
		oSelUtil.ufClick(driver, email);
		ngWebDriver.waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		if(!oSelUtil.ufGetTextValidation(driver,error_password,oJsDataVal.getString("error_password_aboveFifteen")))
		{
			bBelowSix=false;
			sErrorMessage =sErrorMessage+"problem in error_password_aboveFifteen validation";
		}
		
		if(bBelowSix && bAboveFifteen && bEmpty)
			bRes_Flag=true;
		else
		{
			log.info("Logging :: "+sErrorMessage);
			throw new Exception(sErrorMessage);
		}
		return bRes_Flag;
	}

	/*
	 * Yes Agrre error on below cases
	 * 1. Check and uncheck of Button
	 * 2. without checking button clicking on NEXT STEP
	 * */
	public boolean ufYesIAgreeErrorChecks(String sURL) throws Exception {
		boolean bRes_Flag=false,bAgreeUncheck=true,bAgreeSubmit=true;
		
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufClick(driver, agree);
		//Thread.sleep(1000);
		oSelUtil.ufClick(driver, agree);
		ngWebDriver.waitForAngularRequestsToFinish();
		if(!oSelUtil.ufGetTextValidation(driver,error_YesIAgree,oJsDataVal.getString("error_YesIAgree")))
		{
			bAgreeUncheck=false;
			sErrorMessage =sErrorMessage+"problem in error_YesIAgree_AgreeUncheck validation";
		}
		
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		oSelUtil.ufClick(driver, submit);
		ngWebDriver.waitForAngularRequestsToFinish();
		if(!oSelUtil.ufGetTextValidation(driver,error_YesIAgree,oJsDataVal.getString("error_YesIAgree")))
		{
			bAgreeSubmit=false;
			sErrorMessage =sErrorMessage+"problem in error_YesIAgree_NEXT_STEP validation";
		}
		
		if(bAgreeUncheck && bAgreeSubmit)
			bRes_Flag=true;
		else
		{
			log.info("Logging :: "+sErrorMessage);
			throw new Exception(sErrorMessage);
		}
		return bRes_Flag;
	}
/*
 * Error validation is done for empty FName and LName..
 * */
	public boolean ufFNameLNameErrorChecks(String sURL) throws Exception {
		boolean bRes_Flag=true,bFNameBlank=true,bLNameBlank=true;
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		if(sPortalType.equals(Constants.sCustPortType_Customized))
		{	
			oSelUtil.ufSendKeys(driver,phone, oJsTD_RegTypeVal.getString("Phone"));
			oSelUtil.ufSendKeys(driver, email, oJsTD_RegTypeVal.getString("Email"));
			oSelUtil.ufSendKeys(driver, password, oJsTD_Reg.getString("Password"));
			oSelUtil.ufClick(driver,agree);
			oSelUtil.ufClick(driver, next_Step);
			ngWebDriver.waitForAngularRequestsToFinish();
		}
		oSelUtil.ufClick(driver, F_Name);
		oSelUtil.ufClick(driver, L_Name);
		oSelUtil.ufClick(driver, cli_month);
		if(!oSelUtil.ufGetTextValidation(driver, error_FName, oJsDataVal.getString("error_FName")))
		{
			bFNameBlank=false;
			sErrorMessage =sErrorMessage+"problem in error_FName validation";
		}
		if(!oSelUtil.ufGetTextValidation(driver, error_LName, oJsDataVal.getString("error_LName")))
		{
			bLNameBlank=false;
			sErrorMessage =sErrorMessage+"problem in error_LName validation";
		}
		if(bFNameBlank && bLNameBlank )
			bRes_Flag=true;
		else
		{
			log.info("Logging :: "+sErrorMessage);
			throw new Exception(sErrorMessage);
		}
		return bRes_Flag;
	}	
	
	/*
	 1. Date should be 18 years before else 
2. empty
3. Check for leap year ( enter incorrect values) 
	 * */
	public boolean ufBirthdayErrorChecks(String sURL) throws Exception {
		boolean bRes_Flag=true,bEmpty=true,bBelow18=true,bLeapYear=true;
		ufTakingCustomisePortalToActivationPage(sURL);
		oSelUtil.ufClick(driver, cli_month);
		oSelUtil.ufClick(driver, submit);
		if(!oSelUtil.ufGetTextValidation(driver, error_BirthDate, oJsDataVal.getString("error_BirthDate")))
		{
			bEmpty=false;
			sErrorMessage =sErrorMessage+"problem in error_BirthDate validation";
		}
		
		ufTakingCustomisePortalToActivationPage(sURL);
		oSelUtil.ufClick(driver, cli_month);	
		oSelUtil.ufClick(driver, Sel_MonLeap);
		oSelUtil.ufClick(driver, cli_day);
		oSelUtil.ufClick(driver, Sel_DayLeap);
		oSelUtil.ufClick(driver, cli_year);
		oSelUtil.ufClick(driver, Sel_YearLeap);
		oSelUtil.ufClick(driver, F_Name);
		oSelUtil.ufClick(driver, L_Name);
		ngWebDriver.waitForAngularRequestsToFinish();
		if(!oSelUtil.ufGetTextValidation(driver, error_BirthDate, oJsDataVal.getString("error_BirthDate")))
		{
			bLeapYear=false;
			sErrorMessage =sErrorMessage+"problem in error_BirthDate leap Year validation";
		}
		
		ufTakingCustomisePortalToActivationPage(sURL);
		oSelUtil.ufClick(driver, cli_month);	
		oSelUtil.ufClick(driver, Sel_Bel18Mon);
		oSelUtil.ufClick(driver, cli_day);
		oSelUtil.ufClick(driver, Sel_Bel18Day);
		oSelUtil.ufClick(driver, cli_year);
		oSelUtil.ufClick(driver, Sel_Bel18Yea);
		oSelUtil.ufClick(driver, F_Name);
		oSelUtil.ufClick(driver, L_Name);
		ngWebDriver.waitForAngularRequestsToFinish();
		if(!oSelUtil.ufGetTextValidation(driver, error_BirthDate, oJsDataVal.getString("error_BirthDate_below18")))
		{
			bBelow18=false;
			sErrorMessage =sErrorMessage+"problem in error_BirthDate Below 18 validation";
		}
		
		if(bEmpty && bBelow18 && bLeapYear)
			bRes_Flag=true;
		else
		{
			log.info("Logging :: "+sErrorMessage);
			throw new Exception(sErrorMessage);
		}
		return bRes_Flag;
	}	
	
	/*
	*
 *	This function is used to take portal from registration to activtion page. This needs to be call after every error generation.
 * 	class name is changing once error is generated hence page needs to be refresh
 * */
	public void ufTakingCustomisePortalToActivationPage(String sURL) throws Exception {
		driver.get(sURL);
		ngWebDriver.waitForAngularRequestsToFinish();
		
	if(sPortalType.equals(Constants.sCustPortType_Customized))
	{	
		oSelUtil.ufSendKeys(driver,phone, oJsTD_RegTypeVal.getString("Phone"));
		oSelUtil.ufSendKeys(driver, email, oJsTD_RegTypeVal.getString("Email"));
		oSelUtil.ufSendKeys(driver, password, oJsTD_Reg.getString("Password"));
		oSelUtil.ufClick(driver,agree);
		oSelUtil.ufClick(driver, next_Step);
		ngWebDriver.waitForAngularRequestsToFinish();		
	}
	
	}
		/*
	 	Validation of zip code done for below cases
	 	1. Empty
		2. Invalid
		3. No Stores"
		 */
	
	public boolean ufZipCodeErrorChecks(String sURL) throws Exception {
		boolean bRes_Flag = false,bEmpty=true,bInvalid=true,bNoStore=true;
		ufTakingCustomisePortalToActivationPage(sURL);
		oSelUtil.ufClick(driver, zip);
		oSelUtil.ufClick(driver, submit);
		ngWebDriver.waitForAngularRequestsToFinish();
		if(!oSelUtil.ufGetTextValidation(driver, error_zipcode, oJsDataVal.getString("error_zipcode")))
		{
			bEmpty=false;
			sErrorMessage =sErrorMessage+"problem in error_zipcode validation";
		}
		
		ufTakingCustomisePortalToActivationPage(sURL);
		oSelUtil.ufSendKeys(driver, zip, oJsTD_RegError.getString("error_zipcode_invalid"));
		ngWebDriver.waitForAngularRequestsToFinish();
		
		if(!oSelUtil.ufGetTextValidation(driver, error_zipcode, oJsDataVal.getString("error_zipcode_invalid")))
		{
			bInvalid=false;
			sErrorMessage =sErrorMessage+"problem in error_zipcode_invalid validation";
		}
		
		ufTakingCustomisePortalToActivationPage(sURL);
		oSelUtil.ufSendKeys(driver, zip, oJsTD_RegError.getString("error_zipcode_NoStore"));
		ngWebDriver.waitForAngularRequestsToFinish();
		
		if(!oSelUtil.ufGetTextValidation(driver, error_zipcode_NoStore, oJsDataVal.getString("error_zipcode_NoStore")+oJsTD_RegError.getString("error_zipcode_NoStore")))
		{
			bNoStore=false;
			sErrorMessage =sErrorMessage+"problem in error_zipcode_NoStore validation";
		}
		
		if(bEmpty && bInvalid && bNoStore)
			bRes_Flag=true;
		else
		{
			log.info("Logging :: "+sErrorMessage);
			throw new Exception(sErrorMessage);
		}
		
		return bRes_Flag;
	}
/*
 	Validation of Gender
 	1. When empty
 	
 */
	public boolean ufGenderErrorChecks(String sURL) throws Exception {
		boolean bRes_Flag=true;
		ufTakingCustomisePortalToActivationPage(sURL);
		oSelUtil.ufClick(driver, submit);
		Thread.sleep(2000);
		oSelUtil.ufClick(driver, submit);
		ngWebDriver.waitForAngularRequestsToFinish();
		if(!oSelUtil.ufGetTextValidation(driver, error_gender, oJsDataVal.getString("error_gender")))
		{
			bRes_Flag=false;
			sErrorMessage =sErrorMessage+"problem in error_gender validation";
		}
		
		return bRes_Flag;
	}

	public boolean ufWhenAllEmptyFieldError(String sURL) throws Exception {
		boolean bRes_Flag=true,bPassword=true,bEmptyPhone=true,bEmptyEmail=true,bYesAgree=true,
				bFName=true,bLName=true,bBirthday=true,bZip=true,bgender=true;
		driver.get(sURL);
		oSelUtil.ufClick(driver, next_Step);
		if(!oSelUtil.ufGetTextValidation(driver,error_phone,oJsDataVal.getString("error_phone_empty")))
		{
			bEmptyPhone=false;
			sErrorMessage=sErrorMessage+",error_phone_empty validation fail";
		}
		if(!oSelUtil.ufGetTextValidation(driver,error_password,oJsDataVal.getString("error_password")))
		{
			bPassword=false;
			sErrorMessage =sErrorMessage+"problem in password empty error validation";
		}
		if(!oSelUtil.ufGetTextValidation(driver,error_mail,oJsDataVal.getString("error_email_empty")))
		{
			bEmptyEmail=false;
			sErrorMessage =sErrorMessage+"problem in email empty error validation";
		}
		if(!oSelUtil.ufGetTextValidation(driver,error_YesIAgree,oJsDataVal.getString("error_YesIAgree")))
		{
			bYesAgree=false;
			sErrorMessage =sErrorMessage+"problem in error_YesIAgree validation";
		}
		
		if(sPortalType.equals(Constants.sCustPortType_Customized))
		{	
			oSelUtil.ufSendKeys(driver,phone, oJsTD_RegTypeVal.getString("Phone"));
			oSelUtil.ufSendKeys(driver, email, oJsTD_RegTypeVal.getString("Email"));
			oSelUtil.ufSendKeys(driver, password, oJsTD_Reg.getString("Password"));
			oSelUtil.ufClick(driver,agree);
			oSelUtil.ufClick(driver,agree);
			oSelUtil.ufClick(driver, next_Step);
			ngWebDriver.waitForAngularRequestsToFinish();	
			oSelUtil.ufClick(driver, submit);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, submit);
		}
		if(!oSelUtil.ufGetTextValidation(driver, error_FName, oJsDataVal.getString("error_FName")))
		{
			bFName=false;
			sErrorMessage =sErrorMessage+"problem in error_FName validation";
		}
		if(!oSelUtil.ufGetTextValidation(driver, error_LName, oJsDataVal.getString("error_LName")))
		{
			bLName=false;
			sErrorMessage =sErrorMessage+"problem in error_LName validation";
		}
		if(!oSelUtil.ufGetTextValidation(driver, error_BirthDate, oJsDataVal.getString("error_BirthDate")))
		{
			bBirthday=false;
			sErrorMessage =sErrorMessage+"problem in error_BirthDate validation";
		}
		if(!oSelUtil.ufGetTextValidation(driver, error_zipcode, oJsDataVal.getString("error_zipcode")))
		{
			bZip=false;
			sErrorMessage =sErrorMessage+"problem in error_zipcode validation";
		}
		if(!oSelUtil.ufGetTextValidation(driver, error_gender, oJsDataVal.getString("error_gender")))
		{
			bgender=false;
			sErrorMessage =sErrorMessage+"problem in error_gender validation";
		}
		
		if(bPassword && bEmptyPhone && bEmptyEmail && bYesAgree && 
				bFName && bLName && bBirthday && bZip && bgender)
			bRes_Flag=true;
		else
		{
			bRes_Flag=false;
			log.info("Logging :: "+sErrorMessage);
			throw new Exception(sErrorMessage);
		}
		return bRes_Flag;
	}
}
