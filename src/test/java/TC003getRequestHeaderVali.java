import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003getRequestHeaderVali {
	@Test
	void getAllEmpDetails()
	{
		//specify base URI
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"employees");
		
			
		//print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response body is:" +responsebody);
		
		//capture details of headers from response
		String contentType=response.header("Content-Type");
		System.out.println("Contet type is:" +contentType);
		Assert.assertEquals(contentType,"application/json");
		
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("Contet encoding is:" +contentEncoding);
		Assert.assertEquals(contentEncoding,"gzip");
		

		String server=response.header("server");
		System.out.println("Server is:" +server);
		Assert.assertEquals(server,"nginx");		
		
		
		//Status code validation
		//int statusCode=response.getStatusCode();
		//System.out.println("The status code is:" +statusCode);
		//Assert.assertEquals(statusCode,200);
		
		//status line validation
		//String statusLine=response.getStatusLine();
		//System.out.println("The status line is:" +statusLine);
		//Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");		

		
		
		
	}


}
