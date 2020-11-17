package fakeAPITestcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Post_Request {
	
	public HashMap map=new HashMap();
	
	
	@BeforeClass
	public void postData()
	{
		map.put("name","David");
		map.put("location","France");
		map.put("phone", "123456");
		
		String courseArr[]= {"C","C++"};
		map.put("courses", courseArr);
		
	}
	
	
	@Test
	public void postUser()
	{
		given()
			.contentType("application/json")
			.body(map)
				
		.when()
			.post("http://localhost:3000/users")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("David"))
			.body("location",equalTo("France"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().body();
		
		
	}

}
