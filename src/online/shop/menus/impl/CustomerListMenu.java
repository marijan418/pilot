package online.shop.menus.impl;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;
import online.shop.userManagementService.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	DefaultUserManagementService userManagementService;
	ApplicationContext applicationContext;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		applicationContext = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		applicationContext.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(userManagementService.getUsers());
	}

}
