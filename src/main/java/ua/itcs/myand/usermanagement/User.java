package ua.itcs.myand.usermanagement;


import java.util.Date;

public class User {
private Long id;
private String firstName;
private String lastName;
private Date dateOfBirthd;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDateOfBirthd() {
	return dateOfBirthd;
}
public void setDateOfBirthd(Date dateOfBirthd) {
	this.dateOfBirthd = dateOfBirthd;
}
public Object getFullName() {	
	return getLastName() + ", " + getFirstName();
}
}