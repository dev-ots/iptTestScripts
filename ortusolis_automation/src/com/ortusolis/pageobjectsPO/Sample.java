package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;
import com.paulhammant.ngwebdriver.ByAngular;

public class Sample extends TestBase
{

		
		final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
			
			By Sign_Username,Sign_Password,Signin_SignButton,Signin_Success; 
			public static JSONObject oJsOR_Reg = new JSONObject();
			public static JSONObject oJsTD_Reg = new JSONObject();
			
			
			public void loadLoginPageLOcators() throws Exception {
				oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_Registration.json");
				oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_Registration_1.json");
				loginPageObjects(oJsOR_Reg);
			}
			private void loginPageObjects(JSONObject oJsOR_Reg) {
			
				Sign_Username =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Sign_Username"));
				Sign_Password =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Sign_Password"));
				Signin_SignButton =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_SignButton"));
				Signin_Success =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_Success"));
				
		}

			public boolean login_flowIPT() throws Exception{
				boolean lfipt_flag=false;
				try {

					System.out.println("Starting the Login page of IPT");
					ngWebDriver.waitForAngularRequestsToFinish();
					
					driver.findElement(ByAngular.model("Sign_Username")).sendKeys("SRRAMAK");
					
/*				oSelUtil.ufClear(ngWebDriver, Sign_Username);
				oSelUtil.ufSendKeys(ngWebDriver, Sign_Username, oJsTD_Reg.getString("USER_NAME"));
				
				oSelUtil.ufClear(ngWebDriver, Sign_Password);
				oSelUtil.ufSendKeys(ngWebDriver,Sign_Password, oJsTD_Reg.getString("PASS_WORD"));
				oSelUtil.ufClick(ngWebDriver, Signin_SignButton);
				
				lfipt_flag= oSelUtil.ufGetTextValidation(ngWebDriver, Signin_Success, oJsTD_Reg.getString("Signin_Success"));
				log.info("Text validation welcome page "+lfipt_flag);
*/				}catch(Exception ea) {
					log.info("Exception in login_flow : "+ea);
					lfipt_flag=false;
				}
				return lfipt_flag;
				
			}
		}



