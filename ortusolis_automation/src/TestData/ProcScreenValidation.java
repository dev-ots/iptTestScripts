package TestData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.PJAUsrAdmnScrPO;
import com.ortusolis.pageobjectsPO.ProcDetailsPO;
import com.ortusolis.utilities.TestBase;

public class ProcScreenValidation extends TestBase
{
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
	ProcDetailsPO procUser=new ProcDetailsPO();
	String sTestCaseName="Proc User Landing screen ";
	@Test
	public void PjaUsr() throws Exception
	{
		log.info(oJsConfig.getString("IPT_PROC_LANDING"));
		driver.get("http://53.87.137.65/proc_team_home");
		procUser.loadRegistrationPageLocators();
		procUser.search_ShikeishoDetails();
		
	}
	

}
