package responsevalidations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JSONValidations {

		//@Test
		public void samplerequest()
		{
			/*given()
			
			.when()
				.get("http://localhost:3000/users")
			
			.then()
				.statusCode(200)
				.log().all();*/
			
			//given().when().get("http://localhost:3000/users").then().statusCode(200).log().all();
			when().get("http://localhost:3000/users").then().statusCode(200).log().all();
		}
		
		//@Test
		public void checkDSOndata()
		{
			given()
			
			.when()
				.get("http://localhost:3000/users")
			
			.then()
				.statusCode(200)
				.body("[2].name",equalTo("Smith"))  // single content
				.body("[2].courses",hasItem("RestAPI"))
				.body("[2].courses",hasItems("C++","RestAPI")) //Multiple contents
				
				.log().all();
			
			
		}
		
		@Test
		public void passingParmeters()
		{
			given()
				.pathParam("myparam", "aruba")   // path paramter
				.queryParam("myqparam", "fullText=true") // query parameter
				.param("myheader","Indian")  // header parameter
				
			
			.when()
				.get("https://restcountries.eu/rest/v2/name/{myparam}") //https://restcountries.eu/rest/v2/name/aruba?fullText=true
			
			.then()
				.statusCode(200)
				.log().all();
			
		}
	
}
