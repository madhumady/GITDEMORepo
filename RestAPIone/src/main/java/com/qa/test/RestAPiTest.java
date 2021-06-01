package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase.Base;
import com.qa.TestBase.RestApiClient;


public class RestAPiTest extends Base {

	Base base;
	String Url;
	String apiurl;
	String url;
	RestApiClient restapi;
	
	@BeforeMethod
	public void setup() {
		base=new Base();
		Url=prop.getProperty("URL");
		apiurl=prop.getProperty("serviceUrl");
		url=Url+apiurl;
	}

	@Test
	public void getCallfromClient() throws ClientProtocolException, IOException, JSONException {
		restapi=new RestApiClient();
		restapi.get(url);
	}
	
}
