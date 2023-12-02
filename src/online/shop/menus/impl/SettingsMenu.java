package online.shop.menus.impl;

import java.util.Scanner;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;
import online.shop.userManagementService.impl.DefaultUserManagementService;

public class SettingsMenu implements Menu {
	private ApplicationContext applicationContext;
	private DefaultUserManagementService userMagagementService;

	{
		applicationContext = ApplicationContext.getInstance();
		userMagagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		if (applicationContext.getLoggedInUser() == null) {
			System.out.println("Please log in or create an account to change your account settings");
			applicationContext.getMainMenu().start();
		}
		while (true) {
			printMenuHeader();
			Scanner sc = new Scanner(System.in);
			String choice = sc.next();
			if (choice.equals("menu")) {
				applicationContext.getMainMenu().start();
			} else if (Integer.parseInt(choice) == 1) {
				System.out.println("Enter new password:");
				applicationContext.getLoggedInUser().setPassword(sc.next());
				System.out.println("Your passoword has been successfully changed");
			} else if (Integer.parseInt(choice) == 2) {
				System.out.println("Enter new email:");
				applicationContext.getLoggedInUser().setEmail(sc.next());
				System.out.println("Your email has been successfully changed");
			} else {
				System.out.println("Only 1 and 2 are allowed. Try again.");
				continue;
			}
			applicationContext.getMainMenu().start();
		}

	}

	@Override
	public void printMenuHeader() {
		System.out.println("Settings");
		System.out.println("1. Change Password");
		System.out.println("2. Change Email");

	}

}
