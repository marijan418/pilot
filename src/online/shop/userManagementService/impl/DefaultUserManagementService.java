package online.shop.userManagementService.impl;

import java.util.ArrayList;

import online.shop.user.interfaces.User;
import online.shop.userManagementService.interfaces.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static DefaultUserManagementService instance;
	private static ArrayList<User> users;

	{
		users = new ArrayList<User>();
	}

	@Override
	public String registerUser(User user) {
		users.add(user);
		return "New user is created";
	}

	@Override
	public ArrayList<User> getUsers() {
		return new ArrayList<>(users);
	}

	@Override
	public User getUserByEmail(String userEmail) {
		for (User user : users) {
			if (user.getEmail().equals(userEmail)) {
				return user;
			}
		}
		return null;
	}

	public static DefaultUserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	public void clear() {
		users.clear();
	}

}
