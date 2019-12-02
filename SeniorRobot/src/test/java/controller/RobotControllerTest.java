package controller;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

public class RobotControllerTest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void testRobotMoveOne() {
		RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json")
				.header("Accept", "application/json");
		httpRequest.request(Method.POST, "/SeniorRobot/rest/mars/MM")
		.then().assertThat().statusCode(200)
		.assertThat().body("positionX", equalTo(0))
		.assertThat().body("positionY", equalTo(2))
		.assertThat().body("direction", equalTo("N"));
	}
	
	@Test
	public void testRobotMoveTwo() {
		RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json")
				.header("Accept", "application/json");
		httpRequest.request(Method.POST, "/SeniorRobot/rest/mars/MMLL")
		.then().assertThat().statusCode(200)
		.assertThat().body("positionX", equalTo(0))
		.assertThat().body("positionY", equalTo(2))
		.assertThat().body("direction", equalTo("S"));
	}
	
	@Test
	public void testRobotMoveThree() {
		RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json")
				.header("Accept", "application/json");
		httpRequest.request(Method.POST, "/SeniorRobot/rest/mars/MMMMLRR")
		.then().assertThat().statusCode(200)
		.assertThat().body("positionX", equalTo(0))
		.assertThat().body("positionY", equalTo(4))
		.assertThat().body("direction", equalTo("E"));
	}

}
