package ua.itcs.myand.usermanagement.db;

import java.util.Collection;

import ua.itcs.myand.usermanagement.User;

public interface UserDao {

	User create (User user) throws DatabaseException;
	
	void update (User user) throws DatabaseException;
	
	void delete (User user) throws DatabaseException;
	
	User find(Long id) throws DatabaseException;
	
	Collection findAll() throws DatabaseException;
	
	Collection findAll(String firstName, String LastName) throws DatabaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory);
}
