package online.shop.menus.impl;

import java.util.Scanner;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;
import online.shop.user.impl.DefaultUser;
import online.shop.user.interfaces.User;
import online.shop.userManagementService.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {
	private ApplicationContext applicationContext;
	private DefaultUserManagementService userService;

	{
		applicationContext = ApplicationContext.getInstance();
		userService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		printMenuHeader();
		System.out.println("Enter your first name:");
		String firstName = sc.next();
		System.out.println("Enter your last name:");
		String lastName = sc.next();
		System.out.println("Enter your email:");
		String email = sc.next();

		// verify is email is already in use
		if (userService.getUserByEmail(email) != null) {
			System.out.println("This email is already used by another user. Please, use another email");
			applicationContext.getMainMenu().start();
		} else if (email.isEmpty()) {
			System.out.println("You have to input emial to register. Please, try one more time.");
			applicationContext.getMainMenu().start();
		}
		System.out.println("Enter your password:");
		String password = sc.next();
		User newUser = new DefaultUser(firstName, lastName, email, password);
		applicationContext.setLoggedInUser(newUser);
		userService.registerUser(newUser);
		applicationContext.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Sign Up:");
	}

}
