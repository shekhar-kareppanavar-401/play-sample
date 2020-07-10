package services;


import data.dao.UserDAO;
import data.dto.User;

public class UserServices {
	UserDAO userDao = new UserDAO();
	
	public User getUser(String mailId) {
		System.out.println("in UserServices mailId: "+mailId);
		User user = userDao.getUser(mailId);
		return user;
	}
	
	public User createUser(User user) {
		User createdUser = userDao.createUser(user);
		return createdUser;
	}
	
	public User updateUser(User user) {
		User updatedUser = userDao.updateUser(user);
		return updatedUser;
	}
	

	public void deleteUser(String mailId) {
		userDao.deleteUser(mailId);
	}
}
