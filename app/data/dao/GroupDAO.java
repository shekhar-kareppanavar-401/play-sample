package data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import data.connectors.CassandraConnector;
import data.dto.Group;
import data.dto.User;

public class GroupDAO {
	
	public Group getGroup(String groupName) {
		Group group = new Group();
		List<String> users = new ArrayList<String>();
		
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String selectQuery = "select * from test.group where name = ?";
		ResultSet resultSet = client.getSession().execute(selectQuery,groupName);
		Iterator<Row> itr =  resultSet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			String userMailId = new String();
			group.setGroupId(row.getInt("groupid"));
			group.setGroupName(row.getString("groupname"));
			users.add(row.getString("usermailid"));
		}
		group.setUsers(users);
		return group;
	}
	
	public void createGroup(Group group) {
		User returnUser = null;
		
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String insertQuery = "INSERT INTO test.group (groupId, groupName, usermailid) VALUES (?, ?,?)";
		client.getSession().execute(insertQuery, group.getGroupId(), group.getGroupName(), group.getUsers().get(0));
		return;
	}
	
	public void updateGroup(Group group) {
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String updateQuery = "UPDATE test.group SET groupName = ?, usermailid = ? where groupId = ? ";
		client.getSession().execute(updateQuery, group.getGroupName(), group.getUsers().get(0), group.getGroupId());
		return;
	}
	
	public void deleteGroup(String groupName) {
		
		CassandraConnector client = new CassandraConnector();
		client.connect("localhost", 9042);
		
		String deleteQuery = "DELETE FROM test.group WHERE groupName = ?";
		client.getSession().execute(deleteQuery, groupName);
		return;
	}

}
