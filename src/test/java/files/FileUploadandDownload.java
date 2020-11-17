package files;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

public class FileUploadandDownload {

	@Test(priority=1)
	void testSingleFileUpload()
	{
		File myfile=new File(".\\datafiles\\TestFile.txt");
		
		given()
			.multiPart("file",myfile)
			
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.body("fileName", equalTo("TestFile.txt"));
			
	}
	
	
	@Test(priority=2)
	void testMultipleFilesUpload()
	{
		File myfile1=new File(".\\datafiles\\TestFile1.txt");
		File myfile2=new File(".\\datafiles\\TestFile2.txt");
		
		HashMap<String,File> map=new HashMap<String,File>();
		
		map.put("file1", myfile1);
		map.put("file2", myfile2);
		
		
		given()
			.multiPart("myfiles",map)
						
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		.then()
			.statusCode(200);
			
	}
	
	@Test(priority=3)
	void testFileDownload()
	{
		when()
			.get("http://localhost:8080/downloadFile/TestFile.txt")
		.then()
			.statusCode(200)
			.log().all();
				
	}
	
}
