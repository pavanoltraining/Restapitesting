package fakeAPITestcases;

/*
given()
	set cookies, add auth, add param, set headers info etc....
when()
	get, post,put,delete
then()
	validate status code, extract response, extract headers cookies & response body....
*/

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get_Request {
	
	@Test
	public void getSingleUserData()
	{
		given()
		
		.when()
			.get("http://localhost:3000/users/1")
		.then()
			.statusCode(200)
			.body("id",equalTo(1))
			.body("name",equalTo("John"))
			.body("location",equalTo("india"))
			.body("courses[0]",equalTo("Java"))
			.body("courses[1]",equalTo("Selenium"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().body();
			
			
	}

}
