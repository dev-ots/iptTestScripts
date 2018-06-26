package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class ProcAdmnPO  extends TestBase
{
  By  User_Details, Switch_To_User, Logout, Add_New_Buyer_Section, Add_New_Buyer_Button, Add_New_Buyer_Group_Section,
  Add_New_Buyer_Group_Button, Add_New_Assistant_Section, Add_New_Assistant_Button, Pending_Request_Section, Pending_Request_Top,
  Update_Role_Section, Update_Role_Button, Enter_User_ID, Get_Details_Button, User_Search_Back, UserId_Display, Buyer_Name,
  Contact_Number, Email_Id, Select_Buyer_Group, Submit_Add_User_Button, Assis_UserId, Assistant_Name, Assis_Contact,
  Assis_Email, Assis_Select_Group, Assis_Group, Submit_Add_Assistant, User_Search_BackButton, Pending_Req_UserName,
  Pending_Req_Contact, Pending_Req_Role, Pending_Req_Email, Pending_Req_Approve, Pending_Req_Reject, Pending_Req_Cancel,
  Enter_Details_Back, Update_UserId, Update_BuyerName, Update_Contact, Update_Email, Update_Group_Select, Update_Group,
  Edit_Button, Update_Cancel_Button, Update_Save_Button;
  
  final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	boolean pradmn_login = false;
	
	public void ProcAdmnlocators() throws Exception
	{
		log.info("login as Admin Add New User");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_ProcAdmn.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_ProcAdmn.json");
	//	oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationProcAdmn.json");
	   ProcAdmnPageObjects(oJsOR_Reg);
	}

	private void ProcAdmnPageObjects(JSONObject oJsOR_Reg) 
	{
		User_Details =oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Details"));
		Switch_To_User =oSelUtil.loadWithBy(oJsOR_Reg.getString("Switch_To_User"));
		Logout =oSelUtil.loadWithBy(oJsOR_Reg.getString("Logout"));
		Add_New_Buyer_Section =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_New_Buyer_Section"));
		Add_New_Buyer_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_New_Buyer_Button"));
		Add_New_Buyer_Group_Section =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_New_Buyer_Group_Section"));
		Add_New_Buyer_Group_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_New_Buyer_Group_Button")); 
		Add_New_Assistant_Section =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_New_Assistant_Section"));
		Add_New_Assistant_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_New_Assistant_Button"));
		Pending_Request_Section =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Request_Section"));
		Pending_Request_Top =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Request_Top"));
		Update_Role_Section =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Role_Section"));
		Update_Role_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Role_Button"));
		Enter_User_ID =oSelUtil.loadWithBy(oJsOR_Reg.getString("Enter_User_ID"));
		Get_Details_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Get_Details_Button"));
		User_Search_Back =oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Search_Back"));
		UserId_Display =oSelUtil.loadWithBy(oJsOR_Reg.getString("UserId_Display"));
		UserId_Display =oSelUtil.loadWithBy(oJsOR_Reg.getString("UserId_Display"));
		Contact_Number =oSelUtil.loadWithBy(oJsOR_Reg.getString("Contact_Number"));
		Email_Id =oSelUtil.loadWithBy(oJsOR_Reg.getString("Email_Id"));
		Select_Buyer_Group =oSelUtil.loadWithBy(oJsOR_Reg.getString("Select_Buyer_Group"));
		Submit_Add_User_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Submit_Add_User_Button"));
		Assis_UserId =oSelUtil.loadWithBy(oJsOR_Reg.getString("Assis_UserId"));
		Assistant_Name =oSelUtil.loadWithBy(oJsOR_Reg.getString("Assistant_Name"));
		Assis_Contact =oSelUtil.loadWithBy(oJsOR_Reg.getString("Assis_Contact"));
		Assis_Email =oSelUtil.loadWithBy(oJsOR_Reg.getString("Assis_Email"));
		Assis_Select_Group =oSelUtil.loadWithBy(oJsOR_Reg.getString("Assis_Select_Group"));
		Assis_Group =oSelUtil.loadWithBy(oJsOR_Reg.getString("Assis_Group"));
		Submit_Add_Assistant =oSelUtil.loadWithBy(oJsOR_Reg.getString("Submit_Add_Assistant"));
		User_Search_BackButton =oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Search_BackButton"));
		Pending_Req_UserName =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Req_UserName"));
		Pending_Req_Contact =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Req_Contact"));
		Pending_Req_Role =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Req_Role"));
		Pending_Req_Email =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Req_Email"));
		Pending_Req_Approve =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Req_Approve"));
		Pending_Req_Reject =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Req_Reject"));
		Pending_Req_Cancel =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Req_Cancel"));
		Enter_Details_Back =oSelUtil.loadWithBy(oJsOR_Reg.getString("Enter_Details_Back"));
		Update_UserId =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_UserId"));
		Update_BuyerName =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_BuyerName"));
		Update_Contact =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Contact"));
		Update_Email =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Email"));
		Update_Group_Select =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Group_Select"));
		Update_Group =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Group"));
		Edit_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Edit_Button"));
		Update_Cancel_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Cancel_Button"));
		Update_Save_Button =oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Save_Button"));
		System.out.println("finished loading");
      	}
	
    public  boolean ProcAdActivities() throws Exception
    {
    	
    	try
    	{
    		System.out.println("Inside the main PO function");
    		pradmn_login = addNewSupplierAssistant();
			if(pradmn_login)
			{
				log.info(
						"The user has been successfully added into IPT system");
				
				pradmn_login=false;
				//return lrd_flag;
			}
			
			driver.navigate().to(oJsConfig.getString("IPT_PROC_ADMIN").toString());					
			//Thread.sleep(3000);
		//	pradmn_login = approvePendingRequests();
			
			Thread.sleep(2000);
			
		//	lrd_flag = updateUserRole();
			
				
		log.info("Text validation welcome page "+pradmn_login);
		    	}
    	catch(Exception ex)
    	{
    		log.info("error at the Procurement admin login in IPT system"+ex);
    		pradmn_login = false;
    	}
    	return pradmn_login;
    }

	private boolean approvePendingRequests() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean addNewBuyerUser() {
		try {
			System.out.println("Inside addNewBuyerUser");
			Thread.sleep(3000);
			
			oSelUtil.ufClick(driver, Add_New_Buyer_Section);
			
				Thread.sleep(3000);
		
			oSelUtil.ufClick(driver, Add_New_Buyer_Button);
			ngWebDriver.waitForAngularRequestsToFinish();
			
			oSelUtil.ufClear(driver, Buyer_Name);
			oSelUtil.ufSendKeys(driver, Buyer_Name, "Vidhya");
			
			oSelUtil.ufClear(driver, Contact_Number);
			oSelUtil.ufSendKeys(driver, Contact_Number, "123435");
			
			oSelUtil.ufClear(driver, Email_Id);
			oSelUtil.ufSendKeys(driver, Email_Id, "SRRAMAK");
			
			Thread.sleep(2000);
			
			Select oSelect = new Select(driver.findElement(Select_Buyer_Group));
			oSelect.selectByValue("group1");
			
			if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("group1"))
			{
				pradmn_login=true;
			}

			oSelUtil.ufClick(driver, Submit_Add_User_Button);
							
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pradmn_login=false;
			}
			
			return pradmn_login;
	}
	
	private boolean addNewBuyerGroup() {
		try {
			System.out.println("Inside Add_New_Buyer_Group_Section");
			Thread.sleep(3000);
			
			oSelUtil.ufClick(driver, Add_New_Buyer_Group_Section);
			
				Thread.sleep(3000);
		
			oSelUtil.ufClick(driver, Add_New_Buyer_Group_Button);
			ngWebDriver.waitForAngularRequestsToFinish();
			
			oSelUtil.ufClear(driver, Buyer_Name);
			oSelUtil.ufSendKeys(driver, Buyer_Name, "Vidhya");
			
			oSelUtil.ufClear(driver, Contact_Number);
			oSelUtil.ufSendKeys(driver, Contact_Number, "123435");
			
			oSelUtil.ufClear(driver, Email_Id);
			oSelUtil.ufSendKeys(driver, Email_Id, "SRRAMAK");
			
			Thread.sleep(2000);
			
			Select oSelect = new Select(driver.findElement(Select_Buyer_Group));
			oSelect.selectByValue("group1");
			
			if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("group1"))
			{
				pradmn_login=true;
			}

			oSelUtil.ufClick(driver, Submit_Add_User_Button);
							
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pradmn_login=false;
			}
			
			return pradmn_login;
	}
	
	private boolean addNewSupplierAssistant() {
		try {
			System.out.println("Inside addNewSupplierAssistant");
			Thread.sleep(3000);
			
			oSelUtil.ufClick(driver, Add_New_Assistant_Section);
			
				Thread.sleep(3000);
		
			oSelUtil.ufClick(driver, Add_New_Assistant_Button);
			ngWebDriver.waitForAngularRequestsToFinish();
			
			oSelUtil.ufClear(driver, Assis_UserId);
			oSelUtil.ufSendKeys(driver, Assis_UserId, "Vidhya");
			
			oSelUtil.ufClear(driver, Assistant_Name);
			oSelUtil.ufSendKeys(driver, Assistant_Name, "Vidhya");
			
			oSelUtil.ufClear(driver, Assis_Contact);
			oSelUtil.ufSendKeys(driver, Assis_Contact, "123435");
			
			oSelUtil.ufClear(driver, Assis_Email);
			oSelUtil.ufSendKeys(driver, Assis_Email, "SRRAMAK");
			
			Thread.sleep(2000);
			
			Select oSelect = new Select(driver.findElement(Assis_Select_Group));
			oSelect.selectByValue("");
			
			if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("group1"))
			{
				pradmn_login=true;
			}

			oSelUtil.ufClick(driver, Submit_Add_Assistant);
							
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pradmn_login=false;
			}
			
			return pradmn_login;
	}
}
