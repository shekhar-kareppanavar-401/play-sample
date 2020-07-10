package controllers;


import data.dto.User;
import play.mvc.*;
import services.UserServices;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UserController extends Controller {
	

	UserServices userServices = new UserServices();
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result getUser() {
    	User user = userServices.getUser("testMail@gmail.com");
        return ok(user.toString());
    }
    
    public Result createUser(User user) {
    	User createdUser = userServices.createUser(user);
        return ok(createdUser.toString());
    }
    
    public Result updateUser(User user) {
    	User updatedUser = userServices.updateUser(user);
        return ok(updatedUser.toString());
    }
    
    public Result deleteUser(String mailId) {
    	userServices.deleteUser(mailId);
        return ok("User deleted!!");
    }

}
