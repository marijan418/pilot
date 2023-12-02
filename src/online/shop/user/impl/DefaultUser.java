package online.shop.user.impl;

import online.shop.user.interfaces.User;

public class DefaultUser implements User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private static int counter;

	{
		counter++;
		id = counter;
	}

	public DefaultUser(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	@Override
	public String getFirstName() {

		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}

	@Override
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + firstName + ", Last name=" + lastName + ", Email=" + email + "]";
	}

	public void clear() {
		counter = 0;
		this.id = 0;
	}

}
