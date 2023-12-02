package online.shop.menus.impl;

import java.util.Scanner;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;
import online.shop.user.interfaces.User;
import online.shop.userManagementService.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {
	private ApplicationContext applicationContext;
	private DefaultUserManagementService userService;

	{
		applicationContext = ApplicationContext.getInstance();
		userService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your email");
		String email = sc.next();

		System.out.println("Enter your password");
		String password = sc.next();

		User user = userService.getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
			applicationContext.setLoggedInUser(user);

		} else {
			System.out.println("Unfortunately, such login and passowrd doesn't exist");
		}

		applicationContext.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Sign In:");

	}

}
