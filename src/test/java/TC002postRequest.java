import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002postRequest {
	
	
	@Test
	void createEmpDetails()
	{
		//specify base URI
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Request parameters or request payload
		
		JSONObject requestParams=new JSONObject();
		
		 requestParams.put("employee_name","Pooja123");
		 requestParams.put("employee_salary","123455");
		requestParams.put("employee_age","25");
		 requestParams.put("profile_image","");
		  httprequest.header("Content-Type","application/json"); 
		  
		  
		  httprequest.body(requestParams.toJSONString());
		  
		  //sending request
			Response response=httprequest.request(Method.POST,"create");
			
		
		
		//print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response body is:" +responsebody);
		
		//Status code validation
		int statusCode=response.getStatusCode();
		System.out.println("The status code is:" +statusCode);
		Assert.assertEquals(statusCode,200);
		
		//status line validation
		String statusLine=response.getStatusLine();
		System.out.println("The status line is:" +statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");	
		String msg=response.jsonPath().get("message");
		System.out.println("The messgae is:" +msg);
		Assert.assertEquals(msg,"Successfully! Record has been added.");


		
		
		
	}


	

}
