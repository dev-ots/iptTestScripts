package com.ortusolis.restapi;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.ortusolis.utilities.CommonUtilities;
import com.ortusolis.utilities.RestAPIUtilities;
import com.ortusolis.utilities.TestBase;

public class LoginAPI 
{
	RestAPIUtilities rest=new RestAPIUtilities();
	CommonUtilities oComm = new CommonUtilities();
	//@Test
	public void UserExists() throws Exception
	{
		HashMap<String, String> parameters = new HashMap();
		parameters.put("user_id", "SABIN");
		HashMap <String,String> duplicate = new HashMap();
		String sResponse = rest.ufGet("http://d575aapyh039.jpadc.corpintra.net:8080/ipt/api/v18_1/users/user-Authenication?" , parameters);
		
	
		JSONObject jsonobj = rest.convertStringToJson(sResponse);
	
		JSONObject jsonObject = (JSONObject) jsonobj.get("response");
		String Role;
		Role = jsonObject.getString("designation");
	
		
	}
	@Test
	public void RegisterUser() throws Exception
	{
		RestAssured.baseURI ="http://53.87.137.65:8080/ipt/api/v18_1/users/addUser";
		RequestSpecification request=RestAssured.given();
		HashMap<String, String> parameters= new HashMap();
		parameters.put("firstname", "hem");
		parameters.put("lastname", "lask");
		parameters.put("emailId", "auto@ortusolis.com");
		parameters.put("userid",oComm.generateUnixTimeStamp());
		parameters.put("roleId","R04");
		parameters.put("mode","S");
		request.body(parameters.toString());
		Response res = RestAssured.given().contentType("application/json").parameters(parameters).post();
		int StatusCode = res.getStatusCode();
		System.out.println("The status code recieved"+StatusCode);
		System.out.println("The status code recieved"+res.body().asString());
		//Assert.assertEquals("StatusCode","201");
	}	
	//@Test
	public void UserRgstrByAdmin() throws Exception
	{
		RestAssured.baseURI = "";
	}
		
	
	

}
