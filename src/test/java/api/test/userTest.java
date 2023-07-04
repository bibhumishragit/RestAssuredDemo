package api.test;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.user_endpoints;
import api.payload.User;
import io.restassured.response.Response;

public class userTest {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setup() {
	faker=new Faker();
	userpayload=new User();
	
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	userpayload.setPassword(faker.internet().password(5,10));
	userpayload.setEmail(faker.internet().safeEmailAddress());
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	
	public void testpostUser() {
		Response response=user_endpoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		//Assert.assertEquals(response.getContentType(), userpayload.getFirstName());
	}

	@Test(priority=2)
	public void testreaduserGetUsername() {
		Response response=user_endpoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority=3)
	public void testupdateUser() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response response=user_endpoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		
		//Checking the updated value
		Response responseafterupdate=user_endpoints.createUser(userpayload);
		responseafterupdate.then().log().all();
		Assert.assertEquals(responseafterupdate.getStatusCode(),200);
	}
	
	@Test(priority=4)
	public void deleteUser() {
		Response response=user_endpoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
