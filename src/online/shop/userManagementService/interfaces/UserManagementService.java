package online.shop.userManagementService.interfaces;

import java.util.ArrayList;

import online.shop.user.interfaces.User;

public interface UserManagementService {
	String registerUser(User user);

	ArrayList<User> getUsers();

	User getUserByEmail(String userEmail);

}
