package api.endpoints;

import api.payload.User;
import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import  io.restassured.http.ContentType;
import io.restassured.response.Response;
public class user_endpoints {

	public static Response createUser(User payload) {
		Response response=RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		.when().post(Routes.Post_url);
		return response;
	}
	public static Response readUser(String userName) {
		Response response=RestAssured.given().pathParam("username", userName)
		.when().get(Routes.Get_url);
		return response;
	}
	public static Response deleteUser(String userName) {
		Response response=RestAssured.given().pathParam("username",userName)
		.when().delete(Routes.Delete_url);
		return response;
	}
	public static Response updateUser(String userName, User payload) {
		Response response=RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).pathParam("username",userName)
		.when().put(Routes.Update_url);
		return response;
	}
}
