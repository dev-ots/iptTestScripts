package com.ortusolis.utilities;




import java.util.HashMap;

import org.json.JSONObject;
import org.jsoup.select.Evaluator.ContainsText;
import org.slf4j.*;
import com.jayway.restassured.*;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

public class RestAPIUtilities extends TestBase{
		
		final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

	public String ufGet(String sURL, HashMap<String, String> hmParmaeters)  throws Exception{
		 
		RestAssured.baseURI=sURL;
		Response re = RestAssured.given().contentType("application/json").
				parameters(hmParmaeters).get();
		int statusCode = re.getStatusCode();
		System.out.println("Status codde is " +statusCode);
		System.out.println(re.body().asString());
		/*String bodyString = re.getBody().asString();
		
		System.out.println(re.getStatusCode());
		System.out.println(bodyString);
		*/
		return re.body().asString();
	}
	
	public JSONObject convertStringToJson(String strJson) throws Exception
	{
		JSONObject jsObj = new JSONObject(strJson);
		
		return jsObj;
	}
	
	
	
	
}
