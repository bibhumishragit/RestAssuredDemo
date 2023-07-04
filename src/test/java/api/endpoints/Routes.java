package api.endpoints;


/*
 Swagger URI--> https://petstore.swagger.io
 
 Create User(Post)::https://petstore.swagger.io/v2/user
 Get User(Get)::https://petstore.swagger.io/v2/user/{username}
 Update User(Put)::https://petstore.swagger.io/v2/user/{username}
 Delete User(Post)::https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {
	public static String base_url="https://petstore.swagger.io/v2";
	

	//User URL	
	
	public static String Post_url=base_url+"/user";
	public static String Get_url=base_url+"/user/{username}";
	public static String Update_url=base_url+"/user/{username}";
	public static String Delete_url=base_url+"/user/{username}";
}
