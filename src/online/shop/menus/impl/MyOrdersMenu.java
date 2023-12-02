package online.shop.menus.impl;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;
import online.shop.orderManagementService.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {
	private ApplicationContext applicationContext;
	private DefaultOrderManagementService orderManagementService;
	{
		applicationContext = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		if (applicationContext.getLoggedInUser() != null
				&& orderManagementService.getOrdersByUserId(applicationContext.getLoggedInUser().getId()) != null) {
			System.out.println(orderManagementService.getOrdersByUserId(applicationContext.getLoggedInUser().getId()));
		} else if (applicationContext.getLoggedInUser() == null) {
			System.out.println("Please login or create an account");
		} else if (orderManagementService.getOrdersByUserId(applicationContext.getLoggedInUser().getId()) == null) {
			System.out.println(
					"Unfortunately, you don't have any orders yet. navigate back to main menu to place a new order");
		}
		applicationContext.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("My Orders.");

	}

}
