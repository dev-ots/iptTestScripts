package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class RDDetailsPO extends TestBase {

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

	By User_Details, Switch_User, logout_IPT, Shikeisho_Number_Nav, Shikeisho_Number_Header, Shikeisho_Number, Subject,
			EO_Number, Desired_Date, Status, Funding_Appr_link, Designer_Name, Requester_Id, Kanri_Number,
			Kanri_6_Digit, Model_Number, Part_Number, Part_Name, Quantity, PPS, Part_Desired_Date, Part_Classification,
			Part_Status, Pagination_Page, Previous_Page, Next_Page, SHIKEISHO_ACTION_SECTION, CHANGED_SHIKEISHO_ID,
			APPROVE_BOM_CHANGE_SHIKEISHO;

	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	boolean lrd_flag = false;

	public void loadRDDetailsPO() throws Exception {
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(
				System.getProperty("user.dir") + "/src/objectRepo/locators_RDDetailScreen.json");
		oJsTD_Reg = oComUtil
				.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_AdminScreens.json");
		rdDetailsPageObjects(oJsOR_Reg);
	}

	private void rdDetailsPageObjects(JSONObject oJsOR_Reg) {

		User_Details = oSelUtil.loadWithBy(oJsOR_Reg.getString("User_Details"));
		Switch_User = oSelUtil.loadWithBy(oJsOR_Reg.getString("Switch_User"));
		logout_IPT = oSelUtil.loadWithBy(oJsOR_Reg.getString("logout_IPT"));
		Shikeisho_Number_Nav = oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number_Nav"));
		Shikeisho_Number_Header = oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number_Header"));
		Shikeisho_Number = oSelUtil.loadWithBy(oJsOR_Reg.getString("Shikeisho_Number"));
		Subject = oSelUtil.loadWithBy(oJsOR_Reg.getString("Subject"));
		EO_Number = oSelUtil.loadWithBy(oJsOR_Reg.getString("EO_Number"));
		Desired_Date = oSelUtil.loadWithBy(oJsOR_Reg.getString("Desired_Date"));
		Status = oSelUtil.loadWithBy(oJsOR_Reg.getString("Status"));
		Funding_Appr_link = oSelUtil.loadWithBy(oJsOR_Reg.getString("Funding_Appr_link"));
		Designer_Name = oSelUtil.loadWithBy(oJsOR_Reg.getString("Designer_Name"));

		Requester_Id = oSelUtil.loadWithBy(oJsOR_Reg.getString("Requester_Id"));
		Kanri_Number = oSelUtil.loadWithBy(oJsOR_Reg.getString("Kanri_Number"));
		Kanri_6_Digit = oSelUtil.loadWithBy(oJsOR_Reg.getString("Kanri_6_Digit"));
		Model_Number = oSelUtil.loadWithBy(oJsOR_Reg.getString("Model_Number"));
		Part_Number = oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Number"));
		Part_Name = oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Name"));
		Quantity = oSelUtil.loadWithBy(oJsOR_Reg.getString("Quantity"));
		PPS = oSelUtil.loadWithBy(oJsOR_Reg.getString("PPS"));
		Part_Desired_Date = oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Desired_Date"));
		Part_Classification = oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Classification"));
		Part_Status = oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Status"));
		Pagination_Page = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pagination_Page"));
		Previous_Page = oSelUtil.loadWithBy(oJsOR_Reg.getString("Previous_Page"));
		Next_Page = oSelUtil.loadWithBy(oJsOR_Reg.getString("Next_Page"));
		SHIKEISHO_ACTION_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("SHIKEISHO_ACTION_SECTION"));
		CHANGED_SHIKEISHO_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("CHANGED_SHIKEISHO_ID"));
		APPROVE_BOM_CHANGE_SHIKEISHO = oSelUtil.loadWithBy(oJsOR_Reg.getString("APPROVE_BOM_CHANGE_SHIKEISHO"));

	}

	public boolean rdDetailsValidate() throws Exception {

		try {

			ngWebDriver.waitForAngularRequestsToFinish();

			boolean lrd_flag = validateShikeishoDetails();

			if (lrd_flag) {
				log.info("The user has switched the role to Admin");
				driver.navigate().to(oJsConfig.getString("IPT_RD_ADMIN").toString());
				lrd_flag = false;
			}

			log.info("Text validation welcome page " + lrd_flag);
		} catch (Exception ea) {
			log.info("Exception in login_flow : " + ea);
			lrd_flag = false;
		}
		return lrd_flag;

	}

	private boolean validateShikeishoDetails() {
		try {

			oSelUtil.ufIsDisplayed(driver, Desired_Date);
			oSelUtil.ufIsDisplayed(driver, EO_Number);
			oSelUtil.ufIsDisplayed(driver, Shikeisho_Number);
			oSelUtil.ufIsDisplayed(driver, Funding_Appr_link);
			// oSelUtil.ufClick(driver, Funding_Appr_link);

			oSelUtil.ufClick(driver, User_Details);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, Switch_User);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean ViewvingBOMChangedShikeishoByRD() throws Exception {
		boolean bom_change_shikeisho = false;
		try {

			List<WebElement> Action_Shikeisho = oSelUtil.ufGetWebElements(driver, SHIKEISHO_ACTION_SECTION);
			Action_Shikeisho.get(2).click();
			List<WebElement> allShikeisho = oSelUtil.ufGetWebElements(driver, CHANGED_SHIKEISHO_ID);
			for (int i = 0; i < allShikeisho.size(); i++) {
				int iContainText1 = oSelUtil.getIndexOfMatchingTextWebElements(allShikeisho,
						oJsTD_Reg.getString("BOM_CHANGE_SHIKEISHO_ID"));
				allShikeisho.get(iContainText1).click();
			}

			oSelUtil.ufClick(driver, APPROVE_BOM_CHANGE_SHIKEISHO);

		} catch (Exception bcs) {
			log.info("Fails to approve the Shikeisho Quantity changed by the BOM" + bcs.getMessage());
			bom_change_shikeisho = false;
		}
		return bom_change_shikeisho;
	}

}
