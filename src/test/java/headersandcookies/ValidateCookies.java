package headersandcookies;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ValidateCookies {
	
	@Test
	public void testCookies()
	{
		Response res=given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		
		.then()
			.extract()
			.response();
		
		
		Cookie cookie_info=res.getDetailedCookie("__cfduid");
		
		//Expiry Date
		System.out.println(cookie_info.hasExpiryDate());  //true/false
		Assert.assertEquals(true, cookie_info.hasExpiryDate());
		System.out.println(cookie_info.getExpiryDate()); 	 //prints expiry date of cookie
	
		
		//Value
		System.out.println(cookie_info.hasValue()); //true/false
		Assert.assertEquals(true, cookie_info.hasValue());
		System.out.println(cookie_info.getValue());
		
		//Domain
		System.out.println(cookie_info.hasDomain()); //true/false
		Assert.assertEquals(true, cookie_info.hasDomain());
		System.out.println(cookie_info.getDomain());
		
		//Path
		System.out.println(cookie_info.hasPath()); //true/false
		Assert.assertEquals(true, cookie_info.hasPath());
		System.out.println(cookie_info.getPath());
		
		//Somethng
		System.out.println(cookie_info.hasSameSite()); //true/false
		Assert.assertEquals(true, cookie_info.hasSameSite());
		System.out.println(cookie_info.getSameSite());
				
	}
}
