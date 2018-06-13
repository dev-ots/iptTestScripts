package com.ortusolis.utilities;


import java.util.HashMap;

import org.slf4j.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RestAPIUtilities extends TestBase{
		
		final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

		public String ufGet(String sURL, HashMap<String, String> hmParmaeters)  throws Exception{
			 
			RestAssured.baseURI=sURL;
			Response re = RestAssured.given().contentType("application/json").
					parameters(hmParmaeters).get();
		
			/*String bodyString = re.getBody().asString();
			
			System.out.println(re.getStatusCode());
			System.out.println(bodyString);
			*/
			return re.getBody().asString();
		}
	
	
}
