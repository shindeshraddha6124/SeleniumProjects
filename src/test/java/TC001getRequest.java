import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001getRequest {

	@Test
	void getEmpDetails()
	{
		//specify base URI
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employee/";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"1");
		
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
		Headers allHeaders=response.getHeaders();
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		
		
		
	}

}
