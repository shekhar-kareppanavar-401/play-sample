package data.dao;

import java.util.Iterator;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import data.connectors.CassandraConnector;
import data.dto.User;

public class UserDAO {
	
	public User getUser(String mailId) {
		User user = null;
		
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String selectQuery = "select * from test.user where userid = 1000";
		ResultSet resultSet = client.getSession().execute(selectQuery);
		System.out.println("resultSet:"+resultSet);
		Iterator<Row> itr =  resultSet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			user = new User();
			user.setUserId(row.getInt("userid"));
			user.setName(row.getString("name"));
			user.setEmailId(row.getString("emailid"));
		}
		return user;
	}
	
	public User createUser(User user) {
		User returnUser = null;
		
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String insertQuery = "INSERT INTO test.user (userId, name, emailId) VALUES (?, ?,?)";
		ResultSet resultSet = client.getSession().execute(insertQuery, user.getUserId(), user.getName(), user.getEmailId());
		System.out.println("resultSet:"+resultSet);
		Iterator<Row> itr =  resultSet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			returnUser = new User();
			returnUser.setUserId(row.getInt("userid"));
			returnUser.setName(row.getString("name"));
			returnUser.setEmailId(row.getString("emailid"));
		}
		return returnUser;
	}
	
	public User updateUser(User user) {
		User updatedUser = null;
		
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String updateQuery = "UPDATE test.user SET name = ?, emailid = ? where userid = ? ";
		ResultSet resultSet = client.getSession().execute(updateQuery, user.getName(), user.getEmailId(), user.getUserId());
		System.out.println("resultSet:"+resultSet);
		Iterator<Row> itr =  resultSet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			updatedUser = new User();
			updatedUser.setUserId(row.getInt("userid"));
			updatedUser.setName(row.getString("name"));
			updatedUser.setEmailId(row.getString("emailid"));
		}
		return updatedUser;
	}
	
	public void deleteUser(String mailId) {
		
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String deleteQuery = "DELETE FROM test.user WHERE emailid = ?";
		client.getSession().execute(deleteQuery, mailId);
	}

}
