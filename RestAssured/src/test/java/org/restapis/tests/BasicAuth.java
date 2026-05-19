package org.restapis.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;  

public class BasicAuth {

	@Test
	public void TC_001() {
		
		
		String pl = """
			      {
				    "username" : "admin",
				    "password" : "password123"
				  }
			""";
		
		given().baseUri("https://restful-booker.herokuapp.com/auth").contentType("application/json").body(pl)
		.when().post()
		.then()
		.statusCode(200).body("token", notNullValue()).body("token.length()", equalTo(15)).log().all();
		
		
	}
	
	@Test
	public void TC_002() {
		
		
		String pl = """
			      {
				    "username" : "admin",
				    "password" : "password123"
				  }
			""";
		Response res = 
		given().baseUri("https://restful-booker.herokuapp.com/auth").contentType("application/json").body(pl)
		.when().post();
		
		String token = res.jsonPath().get("token");
		System.out.println("Token :"+token);
		
		
		
		//Chaining
		//given().auth().oauth2(token).when().get("URI of the another Server").then().statusCode(200);
	}
	
	
	//For status code how to validate it 
	@Test
	public void TC_003() {
		
		
		String pl = """
			      {
				    "username" : "admin",
				    "password" : "password123"
				  }
			""";
		Response res = 
		given().baseUri("https://restful-booker.herokuapp.com/auth").contentType("application/json").body(pl)
		.when().post();//.statusCode(anyOf(is(200), is(201))).log().all();
		
		
		 int statusCode = res.getStatusCode(); 
		 System.out.println("Status Code: " + statusCode);

		 
		 assertThat(statusCode, anyOf(is(200),is(201)));
		 
		
		
	}
	
	
	
	
}
