package responsevalidations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class XMLValidations {

	//@Test
	public void testSigleandMultopleContent()
	{
	
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.statusCode(200)
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY", equalTo("Seattle"))
			.log().body();
		
		
	}
	
	
	//@Test
	public void testMultipleContentsinSingleshot()
	{
	
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.statusCode(200)
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"))
			.log().body();
		
		
	}
	
	
	@Test
	public void testUsinnXpath()
	{
	
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.statusCode(200)
			.body(hasXPath("/CUSTOMER/FIRSTNAME"),containsString("Bill"))
			.body(hasXPath("/CUSTOMER/FIRSTNAME[text()='Bill']"))
			.log().body();
		
	}
	
	
	@Test
	public void testUsingnXpath2()
	{
	
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.statusCode(200)
			.body(hasXPath("/INVOICEList/INVOICE[text()='10']"))
			.log().body();
		
		
	}
	
}
