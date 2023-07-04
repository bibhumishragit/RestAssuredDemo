package api.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import api.endpoints.user_endpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostuser(String Id,String UserName,String FirstName,String LastName,String PhoneNumber,String Email) {
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(Id));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPhone(PhoneNumber);
		
		Response response=user_endpoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	
	/*@Test(priority=2,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void getUser(String UserName) {
		User userPayload=new User();
		
		
		userPayload.setUsername(UserName);
		Response response=user_endpoints.readUser(UserName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}*/
	
	@Test(priority=3,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteuser(String UserName) {
		Response response=user_endpoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
