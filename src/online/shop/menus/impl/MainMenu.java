package online.shop.menus.impl;

import java.util.Scanner;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;

public class MainMenu implements Menu {

	private ApplicationContext applicationContext;

	{
		applicationContext = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		if (applicationContext.getMainMenu() == null) {
			applicationContext.setMainMenu(this);
		}

		Scanner sc = new Scanner(System.in);

		Menu nextMenu = null;
		boolean go = true;

		while (go) {
			printMenuHeader();
			String userInput = sc.next();
			if (userInput.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			int userChoice = Integer.parseInt(userInput);
			switch (userChoice) {
			case 1:
				nextMenu = new SignUpMenu();
				go = false;
				break;
			case 2:
				nextMenu = applicationContext.getLoggedInUser() != null ? new SignOutMenu() : new SignInMenu();
				go = false;
				break;
			case 3:
				nextMenu = new ProductCatalogMenu();
				go = false;
				break;
			case 4:
				nextMenu = new MyOrdersMenu();
				go = false;
				break;
			case 5:
				nextMenu = new SettingsMenu();
				go = false;
				break;
			case 6:
				nextMenu = new CustomerListMenu();
				go = false;
				break;
			default:
				System.out.println("“Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
				continue;
			}
			nextMenu.start();

		}

	}

	@Override
	public void printMenuHeader() {
		System.out.println("1. Sign Up");
		if (applicationContext.getLoggedInUser() != null) {
			System.out.println("2. Sign Out");
		} else {
			System.out.println("2. Sign In");
		}
		System.out.println("3. Product Catalog");
		System.out.println("4. My Orders");
		System.out.println("5. Settings");
		System.out.println("6. Customer List");
	}

}
