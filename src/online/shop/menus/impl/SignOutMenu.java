package online.shop.menus.impl;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;

public class SignOutMenu implements Menu {
	private ApplicationContext applicationContext;

	{
		applicationContext = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		applicationContext.setLoggedInUser(null);
		applicationContext.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Have a nice day! Look forward to welcoming you back");
	}
}
