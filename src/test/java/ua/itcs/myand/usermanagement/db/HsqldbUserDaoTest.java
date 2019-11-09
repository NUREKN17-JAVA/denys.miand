package ua.itcs.myand.usermanagement.db;

import java.util.Date;

import junit.framework.TestCase;
import ua.itcs.myand.usermanagement.User;

public class HsqldbUserDaoTest extends TestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	protected void setUp() throws Exception {
		super.setUp();
		connectionFactory = new ConnectionFactoryImpl();
		dao = new HsqldbUserDao(connectionFactory);
	}

	public void testCreate() {
		try {
			User user = new User();
			user.setFirstName("John");
			user.setLastName("Doe");
			user.setDateOfBirthd(new Date());
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
