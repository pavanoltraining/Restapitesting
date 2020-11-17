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


public class Delete_Request {
	
	@Test
	public void getSingleUserData()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/users/4")
		.then()
			.statusCode(200)
			.log().body();
			
			
	}

}
