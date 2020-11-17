package fakeAPITestcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Put_Request {
	
	public HashMap map=new HashMap();
	
	
	@BeforeClass
	public void postData()
	{
		map.put("name","David");
		map.put("location","Germany");
		map.put("phone", "654321");
		
		String courseArr[]= {"APITesting","Selenium"};
		map.put("courses", courseArr);
		
	}
	
	
	@Test
	public void postUser()
	{
		given()
			.contentType("application/json")
			.body(map)
				
		.when()
			.put("http://localhost:3000/users/4")
		
		.then()
			.statusCode(200)
			.body("name",equalTo("David"))
			.body("location",equalTo("Germany"))
			.body("courses[0]",equalTo("APITesting"))
			.body("courses[1]",equalTo("Selenium"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().body();
		
		
	}

}
