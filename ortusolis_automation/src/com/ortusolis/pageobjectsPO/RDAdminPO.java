package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class RDAdminPO extends TestBase
{

		
		final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
			
			By 
			Admin_User,Add_User,Pending_Requests,Update_Role,Add_User_Button,
			User_Name,Contact_Number,Daimler_ID,Department,User_Role,
			Submit_Add_User_Button,Pending_Requests_For_Admin,Request_User_Name,
			Request_Contact_Number,Request_User_Role,Request_Department,
			Approve_Request,Update_Daimler_Id,Daimler_Id_Details,Get_Details_Button,
			Update_User_Name,Update_Contact_Number,Update_Email,Update_UserRole,
			Update_UserRole_Dropdown,Submit_Button;
			
			public static JSONObject oJsOR_Reg = new JSONObject();
			public static JSONObject oJsTD_Reg = new JSONObject();
			boolean lrd_flag=false;
			
			public void loadLoginPageLOcators() throws Exception {
				oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_AdminScreens.json");
				oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_AdminScreens.json");
				loginPageObjects(oJsOR_Reg);
			}
			private void loginPageObjects(JSONObject oJsOR_Reg) {
			
				Admin_User =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Admin_User"));
				Add_User =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_User"));
				Pending_Requests =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Requests"));
				Update_Role =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Role"));
				Add_User_Button =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_User_Button"));
				User_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Name"));
				Contact_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Contact_Number"));
				Daimler_ID =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimler_ID"));
				Department =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Department"));
				User_Role =  oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Role"));
				Submit_Add_User_Button =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Submit_Add_User_Button"));
				Pending_Requests_For_Admin =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Pending_Requests_For_Admin"));
				
				Request_User_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Request_User_Name"));
				Request_Contact_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Request_Contact_Number"));
				Request_User_Role =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Request_User_Role"));
				Request_Department =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Request_Department"));
				Approve_Request = oSelUtil.loadWithBy(oJsOR_Reg.getString("Approve_Request"));
				Update_Daimler_Id =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Daimler_Id"));
				Daimler_Id_Details =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimler_Id_Details"));
				Get_Details_Button =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Get_Details_Button"));
				Update_User_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_User_Name"));
				Update_Contact_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Contact_Number"));
				Update_Email =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_Email"));
				Update_UserRole =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_UserRole"));
				Update_UserRole_Dropdown =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Update_UserRole_Dropdown"));
				Submit_Button =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Submit_Button"));
				
				
		}

			public boolean rdAdminActivities() throws Exception{
				
				try {

					ngWebDriver.waitForAngularRequestsToFinish();
				
					lrd_flag = addNewRDUser();
					if(lrd_flag)
					{
						log.info("The user has been successfully added into IPT system");
					}
					
					lrd_flag = updateUserRole();
					
						
				log.info("Text validation welcome page "+lrd_flag);
				}catch(Exception ea) {
					log.info("Exception in login_flow : "+ea);
					lrd_flag=false;
				}
				return lrd_flag;
				
			}
			
			
			private boolean updateUserRole() {
				lrd_flag= false;
				try {
					Thread.sleep(2000);
					
					oSelUtil.ufClick(driver, Update_Role);
					Thread.sleep(2000);
					
					oSelUtil.ufClick(driver, Update_Daimler_Id);
					
					ngWebDriver.waitForAngularRequestsToFinish();
					
					oSelUtil.ufClear(driver, Daimler_Id_Details);
					oSelUtil.ufSendKeys(driver, Daimler_Id_Details, "SRRAMAK");
					oSelUtil.ufClick(driver, Get_Details_Button);
					
					
				}catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				
				// TODO Auto-generated method stub
				return false;
			}
			private boolean addNewRDUser()
			{
				try {
				Thread.sleep(5000);
				
				oSelUtil.ufClick(driver, Add_User);
				
					Thread.sleep(5000);
			
				oSelUtil.ufClick(driver, Add_User_Button);
				ngWebDriver.waitForAngularRequestsToFinish();
				
				oSelUtil.ufClear(driver, User_Name);
				oSelUtil.ufSendKeys(driver, User_Name, "Vidhya");
				
				oSelUtil.ufClear(driver, Contact_Number);
				oSelUtil.ufSendKeys(driver, Contact_Number, "123435");
				
				oSelUtil.ufClear(driver, Daimler_ID);
				oSelUtil.ufSendKeys(driver, Daimler_ID, "SRRAMAK");
				
				oSelUtil.ufClear(driver, Department);
				oSelUtil.ufSendKeys(driver, Department, "RD");
				
				//oSelUtil.ufClick(driver, User_Role);
				Thread.sleep(2000);
				
				Select oSelect = new Select(driver.findElement(User_Role));
				oSelect.selectByValue("admin");
				
				if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("admin"))
				{
					System.out.println("Admin");
					//driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING").toString());
				}
				oSelUtil.ufClick(driver, Submit_Add_User_Button);
				
				Thread.sleep(5000);
				
				
				
				
				
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return lrd_flag;
			}
}



