package services;

import data.dao.GroupDAO;
import data.dto.Group;

public class GroupServices {
	GroupDAO groupDao = new GroupDAO();
	
	public Group getGroup(String groupName) {
		Group group = groupDao.getGroup(groupName);
		return group;
	}
	
	public void createGroup(Group user) {
		groupDao.createGroup(user);
		return;
	}
	
	public void updateGroup(Group user) {
		groupDao.updateGroup(user);
		return updatedUser;
	}
	

	public void deleteGroup(String groupName) {
		groupDao.deleteGroup(groupName);
	}
}
