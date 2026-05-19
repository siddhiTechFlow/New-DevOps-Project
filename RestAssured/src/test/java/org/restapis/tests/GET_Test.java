package org.restapis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class GET_Test {

	@Test
	public void getTest() {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		given().when().get("/employees").then().log().all().statusCode(200);

		
	}

	@Test
	public void getTest_2() {

		RestAssured.baseURI = "https://postman-echo.com";
		
		given().when().get("/get?foo1=bar1&foo2=bar2").then().log().all().statusCode(200);
	}
	
	
	@Test
	public void getTestUser() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		given().when().get("/posts/1").then().log().all().assertThat().statusCode(200).body("id", equalTo(1));
		

		
	}
	
	@Test
	public void test_TC002() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		Response response = given().when().get("/posts/1").then().log().all().extract().response();
		
		int actualStatusCode = response.getStatusCode();
		
		Assert.assertEquals(actualStatusCode, 200);
	}

}