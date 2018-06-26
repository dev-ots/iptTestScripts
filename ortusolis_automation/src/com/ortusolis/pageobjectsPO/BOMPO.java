package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import com.ortusolis.utilities.TestBase;

public class BOMPO extends TestBase 
{
	By New_Rgstr, fname, lname, email, Daimlr, role, Rgstr_Usr, Usr,
	  Pwd, signup, Usr_pro, swtcadmn, Pndg, ClkUsr, ADMIN2TEAM, ADMIN_LOGOUT, SEARCH_BY,SHIKEISHO_NUM,
	  PART_NUM,KANRI_NUM,EO_NUM,SEARCH_FIELD,SEARCH_BUTTON,NEW_SHIKEISHO,CHANGED_SHIKEISHO,SHIKEISHO_ID,
	  PART_ID,KANRI_ID,EO_ID,APPROVE,REJECT,FUNDING_LINK,FUNDING_CLOSE,
	  SUBMIT_BUTTON,ADD_NEW_USER,CONTACT_NUMBER,DAIMLER_DAIMLER,NEW_USER_BUTTON,USER_NAME,DEPARTMENT,ROLE_ROLE,SUBMIT_AND_ADDUSER,
	 UPDATE_USER_ROLE_SECTION, UPDATE_BUTTON, DAIMLER_SEARCH_FIELD,
	 GET_DETAILS, SELECT_ROLE, UPDATE_ROLE_BUTTON,
	 QUANTITIES,VERIFY,YES_BUTTON,SAVE_BUTTON,ASSIGN_BOM,SAVE_BOMUSER,ASSIGN_BUYERCODE,
	 PL_PART,UPDATE_TO_EPICS,APPROVE_BYBOM,EXPORT_EXCEL,LOGOUT,CANCEL_BUTTON;
	 

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void BOMusrLocators() throws Exception
	{
		
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_BOM.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_BOM.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationBOM.json");
	    
		BOMloginpageobjects(oJsOR_Reg);
	}

	private void BOMloginpageobjects(JSONObject oJsOR_Reg) 
	{
		New_Rgstr =oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Rgstr"));
		fname =oSelUtil.loadWithBy(oJsOR_Reg.getString("fname"));
		lname =oSelUtil.loadWithBy(oJsOR_Reg.getString("lname"));
		email =oSelUtil.loadWithBy(oJsOR_Reg.getString("email"));
		Daimlr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimlr"));
		role =oSelUtil.loadWithBy(oJsOR_Reg.getString("role"));
		Rgstr_Usr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Usr"));
		//Rgstr_Sucess =oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Sucess"));
		Usr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr"));
		Pwd =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd"));
		signup =oSelUtil.loadWithBy(oJsOR_Reg.getString("signup"));
		Usr_pro =oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_pro"));
		swtcadmn =oSelUtil.loadWithBy(oJsOR_Reg.getString("swtcadmn"));
		Pndg = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pndg"));
		ClkUsr =oSelUtil.loadWithBy(oJsOR_Reg.getString("ClkUsr"));
	     ADMIN_LOGOUT = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADMIN_LOGOUT"));
	    ADMIN2TEAM = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADMIN2TEAM"));
	    SEARCH_BY = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEARCH_BY"));
	    SHIKEISHO_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("SHIKEISHO_NUM"));
	    PART_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_NUM"));
	    KANRI_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("KANRI_NUM"));
	    EO_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("EO_NUM"));
	    SEARCH_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEARCH_FIELD"));
	    SEARCH_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEARCH_BUTTON"));
	    NEW_SHIKEISHO = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_SHIKEISHO"));
	    CHANGED_SHIKEISHO = oSelUtil.loadWithBy(oJsOR_Reg.getString("CHANGED_SHIKEISHO"));
	    SHIKEISHO_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("SHIKEISHO_ID"));
	    PART_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_ID"));
	    KANRI_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("KANRI_ID"));
	    EO_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("EO_ID"));
	    APPROVE = oSelUtil.loadWithBy(oJsOR_Reg.getString("APPROVE"));
	    REJECT = oSelUtil.loadWithBy(oJsOR_Reg.getString("REJECT"));
	    FUNDING_LINK = oSelUtil.loadWithBy(oJsOR_Reg.getString("FUNDING_LINK"));
	    FUNDING_CLOSE = oSelUtil.loadWithBy(oJsOR_Reg.getString("FUNDING_CLOSE"));
	    SUBMIT_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUBMIT_BUTTON"));
	    ADD_NEW_USER = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADD_NEW_USER"));
	    NEW_USER_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_USER_BUTTON"));
	    USER_NAME = oSelUtil.loadWithBy(oJsOR_Reg.getString("USER_NAME"));
	    CONTACT_NUMBER = oSelUtil.loadWithBy(oJsOR_Reg.getString("CONTACT_NUMBER"));
	    DAIMLER_DAIMLER = oSelUtil.loadWithBy(oJsOR_Reg.getString("DAIMLER_DAIMLER"));
	    DEPARTMENT =oSelUtil.loadWithBy(oJsOR_Reg.getString("DEPARTMENT"));
	    ROLE_ROLE =oSelUtil.loadWithBy(oJsOR_Reg.getString("ROLE_ROLE"));
	    SUBMIT_AND_ADDUSER =oSelUtil.loadWithBy(oJsOR_Reg.getString("SUBMIT_AND_ADDUSER"));
	    UPDATE_USER_ROLE_SECTION=oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_USER_ROLE_SECTION"));
	    UPDATE_BUTTON =oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_BUTTON"));
	    DAIMLER_SEARCH_FIELD= oSelUtil.loadWithBy(oJsOR_Reg.getString("DAIMLER_SEARCH_FIELD"));
	    GET_DETAILS=oSelUtil.loadWithBy(oJsOR_Reg.getString("GET_DETAILS"));
	    SELECT_ROLE= oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_ROLE"));
	    QUANTITIES= oSelUtil.loadWithBy(oJsOR_Reg.getString("QUANTITIES"));
	    VERIFY= oSelUtil.loadWithBy(oJsOR_Reg.getString("VERIFY"));
	    YES_BUTTON= oSelUtil.loadWithBy(oJsOR_Reg.getString("YES_BUTTON"));
	    SAVE_BUTTON= oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_BUTTON"));
	    ASSIGN_BOM= oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSIGN_BOM"));
        SAVE_BOMUSER= oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_BOMUSER"));
	    ASSIGN_BUYERCODE= oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSIGN_BUYERCODE"));
	    PL_PART= oSelUtil.loadWithBy(oJsOR_Reg.getString("PL_PART"));
	   UPDATE_TO_EPICS= oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_TO_EPICS"));
	    APPROVE_BYBOM= oSelUtil.loadWithBy(oJsOR_Reg.getString("APPROVE_BYBOM"));
	    EXPORT_EXCEL= oSelUtil.loadWithBy(oJsOR_Reg.getString("EXPORT_EXCEL"));
	    LOGOUT = oSelUtil.loadWithBy(oJsOR_Reg.getString("LOGOUT"));
	    CANCEL_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("CANCEL_BUTTON"));
	}
	public boolean BOMlogin() throws Exception
	{
		boolean BOM_login=false;
		try
		{
			oSelUtil.ufClear(driver,Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("UsrId"));
			oSelUtil.ufClear(driver,Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("UsrPwd"));
			oSelUtil.ufClick(driver, signup);
			Thread.sleep(2000);
			Alert all = driver.switchTo().alert();
			all.accept();	
			
		}
		catch(Exception ex)
		{
			log.info("Login error in BOM page"+ex.getMessage());
			BOM_login = false;
		}
		return BOM_login;
		
	}
	
	public boolean BOMADMINlogin() throws Exception
	{
		boolean BOM_login=false;
		try
		{
			oSelUtil.ufClear(driver,Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("AdminId"));
			oSelUtil.ufClear(driver,Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("AdminPwd"));
			oSelUtil.ufClick(driver, signup);
			Thread.sleep(2000);
			Alert all = driver.switchTo().alert();
			all.accept();	
			oSelUtil.ufClick(driver, Usr_pro);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, swtcadmn);
			ngWebDriver.waitForAngularRequestsToFinish();
			
		}
		catch(Exception ex)
		{
			log.info("Login error in BOM page"+ex);
			BOM_login = false;
		}
		return BOM_login;
		
	}
	public boolean RgstrBOMUsr() throws Exception
	{
		boolean rgstrusr=false;
		try
		{
			
			oSelUtil.ufClick(driver, New_Rgstr);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClear(driver, fname);
			oSelUtil.ufSendKeys(driver, fname, oJsTD_Reg.getString("f_name"));
			Thread.sleep(1000);
			oSelUtil.ufClear(driver, lname);
			oSelUtil.ufSendKeys(driver, lname, oJsTD_Reg.getString("l_name"));
			oSelUtil.ufClear(driver, email);
			oSelUtil.ufSendKeys(driver, email, oJsTD_Reg.getString("email"));
			oSelUtil.ufClear(driver, Daimlr);
			oSelUtil.ufSendKeys(driver, Daimlr, oJsTD_Reg.getString("Daimler"));
			//oSelUtil.ufGetWebElement(driver, role);
			Select sc = new Select((WebElement) role);
			sc.selectByVisibleText("LM User");
		    oSelUtil.ufClick(driver, Rgstr_Usr);
		    Thread.sleep(2000);
		    Alert al1=driver.switchTo().alert();
		    String text= al1.getText();
		    log.info("User registered success is"+text);
		   al1.accept();
		   SoftAssert sa = new SoftAssert();
		   sa.assertEquals(text, oJsDataVal.getString("USER_REGISTER"));
		   sa.assertAll();
		   
		    
		   // Robot r= new Robot();
		   // r.keyPress(KeyEvent.VK_ENTER);
		   
		   // oSelUtil.ufGetTextValidation(driver, Rgstr_Sucess, oJsDataVal.getString("Rgstr_success"));
		}
		catch(Exception ea)
		{
			log.info("Error at registering as BOM user"+ea.getMessage());
			rgstrusr=false;
		}
		return rgstrusr;
		
	}
	public boolean AdminAproveUser() throws Exception
	{
		boolean adm_aprvUser=false;
		try
		{
			oSelUtil.ufClick(driver, Pndg);
			Thread.sleep(2000);
		List<WebElement> allusers =oSelUtil.ufGetWebElements(driver, ClkUsr);
		int count= allusers.size();
		for(int i=0;i<allusers.size();i++)
		{
			String USER =allusers.get(i).getText();
			if(USER.contains(oJsTD_Reg.getString("BOM_USER")));
		   oSelUtil.ufClick(driver, ClkUsr);
		}
			oSelUtil.ufClick(driver, APPROVE);
			Thread.sleep(2000);
			Alert alt = driver.switchTo().alert();
			String USER_APPROVED=alt.getText();
			alt.accept();
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(USER_APPROVED, oJsTD_Reg.getString("USER_APPROVAL"));
			sa.assertAll();
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, ADMIN2TEAM);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, ADMIN_LOGOUT);
			
		}
		catch(Exception ep)
		{
			log.info("Unable to login by Admin"+ep.getMessage());
			adm_aprvUser=false;
		}
		return adm_aprvUser;
	}
	
	public boolean UserRgstrByAdmn() throws Exception
	{
		boolean UserByAdmn=false;
		try
		{
			oSelUtil.ufClick(driver, ADD_NEW_USER);	
			oSelUtil.ufClick(driver, NEW_USER_BUTTON);
			oSelUtil.ufClear(driver, USER_NAME);
			oSelUtil.ufSendKeys(driver, USER_NAME, oJsTD_Reg.getString("USER_NAME"));
			oSelUtil.ufClear(driver, CONTACT_NUMBER);
			oSelUtil.ufSendKeys(driver, CONTACT_NUMBER, oJsTD_Reg.getString("CONTACT_NUMBER"));
			oSelUtil.ufClear(driver, DAIMLER_DAIMLER);
			oSelUtil.ufSendKeys(driver, DAIMLER_DAIMLER,oJsTD_Reg.getString("DAIMLER_DAIMLER"));
			oSelUtil.ufClear(driver, DEPARTMENT);
			oSelUtil.ufSendKeys(driver, DEPARTMENT, oJsTD_Reg.getString("DEPARTMENT"));
			Select slt =new Select(driver.findElement(ROLE_ROLE));
			slt.deselectByVisibleText(" User");
			oSelUtil.ufClick(driver, SUBMIT_AND_ADDUSER);
			
			
		}
		catch(Exception ua)
		{
			log.info("Error in registering the user by Admin"+ua.getMessage());
			UserByAdmn=false;
		}
		return UserByAdmn;
	}
	
	public boolean UpdateRoleByAdmin() throws Exception
	{
		boolean updt_role=false;
		try
		{
			oSelUtil.ufClick(driver, UPDATE_USER_ROLE_SECTION);
			oSelUtil.ufClick(driver, UPDATE_BUTTON);
			oSelUtil.ufSendKeys(driver, DAIMLER_SEARCH_FIELD, oJsTD_Reg.getString("DAIMLER_ID_CHANGE_ROLE"));
			oSelUtil.ufClick(driver, GET_DETAILS);
			Select se=new Select(driver.findElement(SELECT_ROLE));
			se.selectByVisibleText("");
			oSelUtil.ufClick(driver, UPDATE_ROLE_BUTTON);
			Alert aaa=driver.switchTo().alert();
			String actualText=aaa.getText();
			aaa.accept();
			SoftAssert sa=new SoftAssert();
			sa.assertEquals(actualText, oJsDataVal.getString("ROLE_CHANGEBYADMIN"));
			sa.assertAll();
			
			
		}
		catch(Exception eu)
		{
			log.info("Fails to change user role by Admin"+eu);
			updt_role=false;
		}
		return updt_role;
	}
	
	public boolean SearchShikeisho() throws Exception
	{
		boolean srh_shi=false;
		try
		{
			oSelUtil.ufClick(driver, SEARCH_BY);
			oSelUtil.ufClick(driver, SHIKEISHO_NUM);
			oSelUtil.ufSendKeys(driver, SEARCH_FIELD, oJsTD_Reg.getString("SHIKEISHO ID"));
			oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			List<WebElement> allusers =oSelUtil.ufGetWebElements(driver, SHIKEISHO_ID);
			int count= allusers.size();
			int iContainText = oSelUtil.getIndexOfMatchingTextWebElements(allusers,oJsTD_Reg.getString("SHIKEISHO_ID"));
			allusers.get(iContainText).click();
			
		}
		catch(Exception ss)
		{
			log.info("Fails in searching shikeisho"+ss.getMessage());
			srh_shi=false;
		}
		return srh_shi;
	}
	
	public boolean VerifyChangedVAlues() throws Exception
	{
		boolean verify_values=false;
		try 
		{
			int qqq=oJsTD_Reg.getInt("QUANTITY");
			List<WebElement> allquan=oSelUtil.ufGetWebElements(driver, QUANTITIES);
			int count2=allquan.size();
			log.info("Number of quantities in field are"+count2);
			for(int i=0;i<allquan.size();i++)
			{
				allquan.get(i).sendKeys("QQQ");
			}
			//oSelUtil.ufSendKeys(driver, QUANTITY, oJsTD_Reg.getString("QUANTITY"));
			oSelUtil.ufClick(driver, VERIFY);
			Alert ala = driver.switchTo().alert();
			String txt =ala.getText();
			ala.accept();
			SoftAssert saa=new SoftAssert();
			saa.assertEquals(txt, oJsDataVal.getString("VERIFFY_MSG"));
			saa.assertAll();
			
			
		}
		catch(Exception vrf)
		{
			log.info("Quantity of parts of Shikeisho not changed"+vrf.getMessage());
			verify_values=false;
		}
		return verify_values;
	}
	public void ChangesApproving() throws Exception
	{
		oSelUtil.ufClick(driver, YES_BUTTON);
		oSelUtil.ufClick(driver, SAVE_BUTTON);
	}
	public void ChangesNotApproved() throws Exception
	{
		oSelUtil.ufClick(driver, CANCEL_BUTTON);
		oSelUtil.ufClick(driver, SAVE_BUTTON);

	}
	public boolean AssignBOMUserforLMAprvShi() throws Exception
	{
		boolean assgn_bomuser=false;
		try
		{
			
			Select sll = new Select(driver.findElement(ASSIGN_BOM));
			sll.selectByVisibleText("");
			oSelUtil.ufClick(driver, SAVE_BOMUSER);
			Select sls = new Select(driver.findElement(ASSIGN_BUYERCODE));
			sll.selectByValue("");
			oSelUtil.ufClick(driver, PL_PART);
			SearchShikeisho();
			oSelUtil.ufClick(driver, UPDATE_TO_EPICS);
			
		}
		catch(Exception ab)
		{
			log.info("Cant able to assign the bom user "+ab.getMessage());
	        assgn_bomuser=false;
	       
		}
		return assgn_bomuser;
	}
	
	public boolean AfterRDLMviewConfirmQuantityByBOM() throws Exception
	{
		boolean after_RDLM=false;
		try
		{
			BOMPO bp =new BOMPO();
			bp.SearchShikeisho();
					oSelUtil.ufClick(driver, APPROVE_BYBOM);
		}
		catch(Exception ard)
		{
			log.info("BOM user unable to confirm the quantity of shikeisho which are approved by RD and LM"+ard);
			after_RDLM=false;
		}
		return after_RDLM;
	}
	
	public boolean ExportToExcel() throws Exception
	{
		boolean export_excel=false;
		try
		{
			BOMPO bp =new BOMPO();
			bp.SearchShikeisho();
			oSelUtil.ufClick(driver, PL_PART);
			oSelUtil.ufClick(driver, EXPORT_EXCEL);
			
		}
		catch(Exception exe)
		{
			log.info(" Shikeisho information is fail in export to excel"+exe.getMessage());
			export_excel=false;
		}
		return export_excel;
	}

  public boolean BOMlogout() throws Exception
  {
	  boolean logout=false;
	  try
	  {
		  oSelUtil.ufClick(driver, Usr_pro);
		  oSelUtil.ufClick(driver, LOGOUT);
		  Alert aller = driver.switchTo().alert();
		  String logoutText=aller.getText();
		  aller.accept();
		  SoftAssert saa= new SoftAssert();
		  saa.assertEquals(logoutText, oJsDataVal.getString("LOGOUT"));
		  saa.assertAll();
	  }
	  catch(Exception lo)
	  {
		  log.info("User fails to logout"+lo.getMessage());
		  logout=false;
	  }
	return logout;
  }
	


	}
