package ua.itcs.myand.usermanagement;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class UserTest extends TestCase {

	private static final int EXPECTED_AGE = 20;
	private static final int DAY_OF_BIRTH = 13;
	private static final int MONTH_OF_BIRTH = 8;
	private static final int YEAR_OF_BIRTH = 1999;
	
	
	private User user;
	private Date dateOfBirthd;
	
	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
		dateOfBirthd = calendar.getTime();
	}

	public void testGetFullName() {
	
		user.setFirstName ("John");
		user.setLastName("Doe");
		assertEquals("Doe, John", user.getFullName() );
	}
	
	public void testGetAge() {
		user.setDateOfBirthd (dateOfBirthd);
		assertEquals(EXPECTED_AGE, user.getAge() );
	}
	
	public void testAgeTodaysBirthday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		user.setDateOfBirthd(calendar.getTime());
		int actual_age = user.getAge();
		assertEquals(EXPECTED_AGE, actual_age);
	}	
	public void testAgeTomorrowsBirthday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		user.setDateOfBirthd(calendar.getTime());
		int actual_age = user.getAge();
		assertEquals(EXPECTED_AGE, actual_age);
	}
}
