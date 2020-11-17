package videogameapi;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VideoGameAPITests {

	public int port=8081;
	public String uri="http://localhost:"+port+"/app";  //http://localhost:8081/app/videogames
	
	@Test(priority=1)
	void test_getAllVideoGames()
	{
		given()
		
		.when()
			.get(uri+"/videogames")
		.then()
			.statusCode(200)
			.log().body();
		
	}
	
	@Test(priority=2)
	void test_addNewVideoGame()
	{
		HashMap data=new HashMap();
		data.put("id", "106");
		data.put("name", "Spider-Man");
		data.put("releaseDate", "2020-09-20T08:55:58.510Z");
		data.put("reviewScore", "5");
		data.put("category", "Adventure");
		data.put("rating", "Universal");
		
		
		Response res=given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post(uri+"/videogames")    //http://localhost:8081/app/videogames
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		//String jsonstring=res.toString();
		//Assert.assertEquals(jsonstring.contains("Record Added Successfully"), true);
		
	}
	
	@Test(priority=3)
	void test_getVideoGame()
	{
		given()
		
		.when()
			.get(uri+"/videogames"+"/106")     //http://localhost:8081/app/videogames/106
		.then()
			.statusCode(200)
			.log().body()
			.body("videoGame.id", equalTo("106"))
			.body("videoGame.name", equalTo("Spider-Man"));
		
	}
	
	@Test(priority=4)
	void test_updateVideoGame()
	{
		HashMap data=new HashMap();
		data.put("id", "106");
		data.put("name", "PacMan");
		data.put("releaseDate", "2020-09-20T08:55:58.510Z");
		data.put("reviewScore", "3");
		data.put("category", "Adventure");
		data.put("rating", "Universal");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.put(uri+"/videogames"+"/106")   //http://localhost:8081/app/videogames/3
		.then()
			.statusCode(200)
			.log().body()
			.body("videoGame.name", equalTo("PacMan"))
			.body("videoGame.reviewScore", equalTo("3"));
	}
	
	@Test(priority=5)
	void test_deleteVideoGame()
	{
		given()
			
		.when()
			.delete(uri+"/videogames"+"/106")
		.then()
			.statusCode(200)
			.log().body();
			
		
	}
}
