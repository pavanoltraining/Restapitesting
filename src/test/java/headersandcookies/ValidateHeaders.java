package headersandcookies;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class ValidateHeaders {
	

	@Test
	public void testHeaders()
	{
		Response res=given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		
		.then()
			.extract()
			.response();
		
		//single header info
		/*String header_contenttype=res.getHeader("Content-Type");
		System.out.println("Content-Type header value is--->"+header_contenttype);
		Assert.assertEquals(header_contenttype, "application/json; charset=utf-8");*/
		
		//multiple header info
		Headers headers=res.getHeaders();
		
		System.out.println("Number of headers returned:"+headers.size());
		
		for(Header h:headers)
		{
			System.out.println(h.getName()+"    "+h.getValue());
		}
		
	}
}
