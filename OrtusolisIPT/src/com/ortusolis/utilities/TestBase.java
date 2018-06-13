package com.ortusolis.utilities;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import com.ortusolis.pageobjectsPO.RegistrationPO;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class TestBase {
	
	
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	public static WebDriver driver=null;
	public static NgWebDriver ngWebDriver=null;
	public static SeleniumUtilities oSelUtil = new SeleniumUtilities();
	public static CommonUtilities oComUtil = new CommonUtilities();
	public static Constants oCons = new Constants();
	public static JSONObject oJsConfig = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	//Creating object for PageObject classes here
	public static RegistrationPO poReg = new RegistrationPO();
	
	public static boolean bTestCase = false;
	public static String sTestCaseName = "";
	public static String sErrorMessage = "";
	
	/*Extent Report settings. String will have value intially.This can be set from any of the program
	By default it will be set to print method name. We can make it for suite name also.

	public static boolean bExtentReportMethodName=false,bExtentReportSuitName=false;
	public static String sExtentReportFormatRequired=null; 
*/
		
	@BeforeSuite
	public void BeforeSuiteDependencyTrigger() throws Exception {
		oJsConfig = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/config/config.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/dataValidation/dataValidation.json");
		oComUtil.ufdeletescreenshots();
		launchBrowser();
			}

	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	
	/*
	 * This function is to launch browser . Browser will picked from config.json file
	 * */
	public void launchBrowser() throws Exception {
		
		//String sBrowser = "chrome";
		String sBrowser = oJsConfig.getString("Browser").toString();
		log.info(sBrowser);
		if(sBrowser.toLowerCase().contains("firefox")) {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		/*FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
		driver = new FirefoxDriver(options);
		*/
		//driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		}else if (sBrowser.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
		}else if(sBrowser.toLowerCase().contains("edge")) {
			//MicrosoftWebDriver.exe
			
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} 
		else {
			log.error("Option is invalid");
		}
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		driver.manage().deleteAllCookies();
	}
	
	/*@BeforeMethod
	public void zzzUfRepotFormatSet() throws Exception {
		if(sExtentReportFormatRequired==null)
			{bExtentReportSuitName=false;bExtentReportMethodName=true;}
		else if(sExtentReportFormatRequired.equals(Constants.sExtentReportFormatSuite))
		{bExtentReportSuitName=true;bExtentReportMethodName=false;}
		
		sExtentReportFormatRequired=null;
	}*/
}
