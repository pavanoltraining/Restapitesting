package headersandcookies;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class Authentications {

	//@Test
	void testBasicauth()
	{
		given()
			// .auth().basic("ToolsQA","TestPassword")  // Basic Authentication
			 .auth().digest("ToolsQA","TestPassword")  //Digest Authentication
		.when()
			.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
		.then()
			.body("FaultId",equalTo("OPERATION_SUCCESS"))
			.body("Fault", equalTo("Operation completed successfully"))
			.statusCode(200);
	}
	
	@Test
	void testBearerTokenAuthentication() throws IOException
	{
		String beartoken="E4F284BFADA11D01A52508ED7B92FFD7EE0905659F5DED06A4B73FC7739B48A287648801";
		String bodymsg=generateStringFromResource(".\\resources\\postData.txt");
		
		given()
			.headers("Authorization","Bearer "+beartoken)
			.contentType("text/xml")
			.body(bodymsg)
		.when()
			.post("https://certtransaction.elementexpress.com")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	public static String generateStringFromResource(String path) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	
	@Test
	void testAPIKeyAuth() throws IOException
	{
		given()
			.param("apikey", "sagdhagsdhasgdha")
		.when()
			.get("www.xyz.com/1?key={apikey}")   
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
}
