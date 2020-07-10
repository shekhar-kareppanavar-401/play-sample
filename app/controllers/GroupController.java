package controllers;


import data.dto.User;
import play.mvc.*;
import services.GroupServices;
import services.UserServices;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class GroupController extends Controller {
	

	GroupServices groupServices = new GroupServices();
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result getGroup() {
    	User user = groupServices.getGroup("groupName");
        return ok(user.toString());
    }
    
    public Result createGroup(User user) {
    	User createdUser = groupServices.createGroup(user);
        return ok(createdUser.toString());
    }
    
    public Result updateGroup(User user) {
    	User updatedUser = groupServices.updateGroup(user);
        return ok(updatedUser.toString());
    }
    
    public Result deleteGroup(String groupName) {
    	groupServices.deleteGroup(groupName);
        return ok("Group deleted!!");
    }

}
