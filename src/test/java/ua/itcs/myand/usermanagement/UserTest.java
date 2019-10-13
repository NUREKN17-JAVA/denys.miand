package ua.itcs.myand.usermanagement;

import junit.framework.TestCase;

public class UserTest extends TestCase {

	private User user;
	
	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
	}

	public void testGetFullName() {
	
		user.setFirstName ("John");
		user.setLastName("Doe");
		assertEquals("Doe, John", user.getFullName() );
	}
}
