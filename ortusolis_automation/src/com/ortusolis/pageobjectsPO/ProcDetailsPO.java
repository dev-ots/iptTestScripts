package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class ProcDetailsPO extends TestBase {
	
	
	

		final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
			
			By User_Profile,Switch_Role,logout,	Search_By_Text,	Search_By_Dropdown,	Search_By_Shikeisho,Search_By_EO,
			Search_By_Part,	Search_By_Kanri,New_Shikeisho_Tab,New_Shikeisho_Count,New_Shikeisho,In_Progress_Tab,
			In_Progress_Count,In_Progress,Changed_Shikeisho_Tab,	Changed_Shiekeisho_Count,Changed_Shikeisho,	
			Part_Received_Tab,Part_Received_Count,Part_Received,Search_Button,funding_Link,funding_Close,
 			User_Name, Switch_Admin_Role,logout_IPT,Shikeisho_Number_Nav,Shikeisho_Number_Header,Shikeisho_Number,
 			Subject,EO_Number,Desired_Date,	Status,	Funding_Appr_link,Designer_Name,Requester_Id,Kanri_Number,
 			Kanri_6_Digit,Model_Number, Part_Number,Part_Name,Quantity,	PPS,Part_Select_Supp_Dropdown,
 			Part_Select_Suppliers,Part_Designer_Name,Part_Designer_Dept,Part_Drawing_URL,Pagination_Page,Previous_Page,
 			Next_Page;
			
			public static JSONObject oJsOR_Reg = new JSONObject();
			public static JSONObject oJsTD_Reg = new JSONObject();
			
			public void loadRegistrationPageLocators() throws Exception {
				oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_ProcScreen.json");
				oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_ProcAdmn.json");
				loadingPageObjects(oJsOR_Reg);
			}
			private void loadingPageObjects(JSONObject oJsOR_Reg) throws Exception {
				User_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Name"));
				Switch_Admin_Role =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Switch_Admin_Role"));
				Search_By_Dropdown =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_By_Dropdown"));
				Search_By_Shikeisho =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_By_Shikeisho"));
				Search_By_EO =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_By_EO"));
				Search_By_Kanri =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_By_Kanri"));
				Search_By_Part =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_By_Part"));
				Search_By_Text =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_By_Text"));
				New_Shikeisho_Count =  oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shikeisho_Count"));
				In_Progress_Tab =  oSelUtil.loadWithBy(oJsOR_Reg.getString("In_Progress_Tab"));
				Part_Received_Tab =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Received_Tab"));
				Search_By_Text = oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_By_Text"));
				Search_Button =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Search_Button"));
				Shikeisho_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number"));
				Desired_Date =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Desired_Date"));
				Status =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Status"));
				Funding_Appr_link =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Funding_Appr_link"));
				New_Shikeisho =oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shikeisho"));
				funding_Link =oSelUtil.loadWithBy(oJsOR_Reg.getString("funding_Link"));
				funding_Close= oSelUtil.loadWithBy(oJsOR_Reg.getString("funding_Close"));
				In_Progress_Count= oSelUtil.loadWithBy(oJsOR_Reg.getString("In_Progress_Count"));
				User_Profile =  oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Profile"));
				Switch_Role =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Switch_Role"));
				logout =  oSelUtil.loadWithBy(oJsOR_Reg.getString("logout"));
				New_Shikeisho_Tab =  oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shikeisho_Tab"));
				In_Progress =  oSelUtil.loadWithBy(oJsOR_Reg.getString("In_Progress"));
				Changed_Shikeisho_Tab =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Changed_Shikeisho_Tab"));
				Changed_Shiekeisho_Count =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Changed_Shiekeisho_Count"));
				Changed_Shikeisho =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Changed_Shikeisho"));
				Part_Received_Count =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Received_Count"));
				Part_Received =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Received"));
				logout_IPT =  oSelUtil.loadWithBy(oJsOR_Reg.getString("logout_IPT"));
				Shikeisho_Number_Nav =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number_Nav"));
				Shikeisho_Number_Header =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number_Header"));
				Subject =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Subject"));
				EO_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("EO_Number"));
				Designer_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Designer_Name"));
				Requester_Id =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Requester_Id"));
				Kanri_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Kanri_Number"));
				Kanri_6_Digit =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Kanri_6_Digit"));
				Model_Number  =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Model_Number"));
				Part_Number =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Number"));
				Part_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Name"));
				Quantity =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Quantity"));
				PPS =  oSelUtil.loadWithBy(oJsOR_Reg.getString("PPS"));
				Part_Select_Supp_Dropdown =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Select_Supp_Dropdown"));
				Part_Select_Suppliers =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Select_Suppliers"));
				Part_Designer_Name =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Designer_Name"));
				Part_Designer_Dept =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Designer_Dept"));
				Part_Drawing_URL =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Drawing_URL"));
				Pagination_Page =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Pagination_Page"));
				Previous_Page =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Previous_Page"));
				Next_Page =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Next_Page"));
				
		}
			
			public boolean search_ShikeishoDetails() throws Exception{
				boolean bRes_flag=false;
				try {
					
				oSelUtil.ufClear(driver, Search_By_Text);
				
				oSelUtil.ufClick(driver, Search_By_Dropdown);
				
				oSelUtil.ufClick(driver,Search_By_EO);
				
				oSelUtil.ufSendKeys(driver, Search_By_Text, oJsTD_Reg.getString("SearchBy_Value"));
				oSelUtil.ufClick(driver, Search_Button);
				if(oSelUtil.ufIsDisplayed(driver, New_Shikeisho_Count)) {
					oSelUtil.ufClick(driver, New_Shikeisho);

					//oSelUtil.ufClick(driver,funding_Link);
					//oSelUtil.ufClick(driver, funding_close);
					
					Thread.sleep(3000);
				}	
					oSelUtil.ufClick(driver, User_Name);
					Thread.sleep(2000);
					oSelUtil.ufClick(driver, Switch_Admin_Role);
					Thread.sleep(2000);
									
				}catch(Exception ea) {
					log.info("Exception in login_flow : "+ea);
					bRes_flag=false;
				}
				return bRes_flag;
				
			}
			
			public boolean switchRoleToAdmin() {
				boolean bRes_flag = false;
				
				try
				{
					ngWebDriver.waitForAngularRequestsToFinish();
					oSelUtil.ufClick(driver, User_Name);
					ngWebDriver.waitForAngularRequestsToFinish();
					oSelUtil.ufClick(driver, Switch_Admin_Role);
					bRes_flag= true;
				}
				catch(Exception ea)
				{
					bRes_flag= false;
				}
				
				return bRes_flag;
			}

}
