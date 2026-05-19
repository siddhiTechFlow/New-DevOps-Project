package org.restapis.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;    

import static io.restassured.RestAssured.*;

public class POST_Test {

	@Test
	public void postTest() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

		String payload = "{\"userId\":1,\"id\":1,\"title\":\"RestAssuredTests\",\"body\":\"JSONPlaceholder\"}";

		given().contentType(ContentType.JSON).body(payload).when().post("/posts").then().statusCode(201)
				.body("title", equalTo("RestAssuredTests")).log().all();
	}

}
