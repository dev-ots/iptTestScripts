package com.ortusolis.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.ortusolis.utilities.CommonUtilities;
import com.ortusolis.utilities.RestAPIUtilities;
import com.paulhammant.ngwebdriver.*;

public class Demo {
	
	String sBrowser = "chrome";
	//String sBrowser = "Firefox";
	//String sBrowser = "edge";
	WebDriver driver;
	NgWebDriver ngWebDriver;
	RestAPIUtilities oRestUtil = new RestAPIUtilities();
	CommonUtilities oCom = new CommonUtilities();
	@BeforeTest
	public void launchBrowser() {
		/*if(sBrowser.contains("Firefox")) {
			System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		    //capabilities.setCapability("marionette", true); 
		    FirefoxOptions options = new FirefoxOptions()
		    	    .setProfile(new FirefoxProfile());
		    	driver = new FirefoxDriver(options);
			//driver = new FirefoxDriver;
			driver.manage().window().maximize();
		}else if (sBrowser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(sBrowser.toLowerCase().contains("edge")) {
			//MicrosoftWebDriver.exe
		} 
		else {
			System.out.println("Option is invalid");
		}
		System.out.println("End of launchBrowser");
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);*/
	}

	@Test
	public void executeBrowser() throws Exception {
		System.out.println("executeBrowser");
		String sResponse;
		System.out.println(oCom.generateUnixTimeStamp());
		//oJsConfig.get(key)
		//sResponse=oRestUtil.ufGet("http://53.87.132.60:8080/api/ipt-user/user_sign_in?", "user_id=BCHINTA");
		//System.out.println(sResponse);
		/*driver.get("https://my.naviit.com/coldstone");
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(ByAngular.model("phone")).sendKeys("4444000005");
		driver.findElement(ByAngular.model("email")).sendKeys("sri@spendgo.com");
		driver.findElement(ByAngular.model("password")).sendKeys("sri@spendgo.com");
		driver.findElement(By.id("agree")).click();
		driver.findElement(ByAngular.buttonText("NEXT STEP")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
*/		}
	@AfterTest
	public void tearDown() {
		//driver.close();
	}
}
