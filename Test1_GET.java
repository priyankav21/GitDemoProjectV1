import org.testng.Assert;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test1_GET {
     
	@Test
	void test_01()
	{
		Response resp=get("https://reqres.in/api/users?page=2");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().asString());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getHeader("content-type"));
		System.out.println(resp.getTime());
		
		int statuscode = resp.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	void test_02() {
		given()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		  .statusCode(200)
		  .body("data.id[0]", equalTo(7));
	}
}
