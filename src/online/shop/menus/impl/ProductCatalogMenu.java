package online.shop.menus.impl;

import java.util.Scanner;

import online.shop.applicationContext.ApplicationContext;
import online.shop.menus.interfaces.Menu;
import online.shop.order.impl.DefaultOrder;
import online.shop.order.interfaces.Order;
import online.shop.orderManagementService.DefaultOrderManagementService;
import online.shop.product.interfaces.Product;
import online.shop.productManagementService.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {
	private ApplicationContext applicationContext;
	private DefaultProductManagementService productManagementService;
	private DefaultOrderManagementService orderManagementService;

	{
		applicationContext = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to main menu");

		while (true) {
			printMenuHeader();
			String choice = sc.next();
			// user inputs 'menu' string
			if (choice.equalsIgnoreCase("menu")) {
				break;
			}
			// NOK - Cart is empty and user inputs 'checkout'
			else if (applicationContext.getLoggedInUser() != null && applicationContext.getSessionCart().isEmpty()
					&& choice.equalsIgnoreCase("checkout")) {
				System.out.println(
						"Your cart is empty. Please, add product to cart first and then proceed with checkout.");
				continue;
			}
			// NOK - user is not logged in
			else if (applicationContext.getLoggedInUser() == null && choice.equalsIgnoreCase("checkout")) {
				System.out.println("You are not logged in. Please sign in or create an account");
				applicationContext.getMainMenu().start();
			}
			// OK - user is logged in, cart is not empty and input is checkout
			else if (!applicationContext.getSessionCart().isEmpty() && choice.equalsIgnoreCase("checkout")) {
				createOrder(sc);
				applicationContext.getSessionCart().clear();
				applicationContext.getMainMenu().start();
			}

			Product productToAdd = productManagementService.getProductById(Integer.parseInt(choice));
			if (productToAdd != null) {
				applicationContext.getSessionCart().addProduct(productToAdd);
				System.out.println("Product " + productToAdd.getProductName()
						+ " has been added to your cart. If you want to add a new product - enter product id. If you want to proceed with checkout - enter word 'checkout' to console");
				continue;
			} else {
				System.out.println(
						"Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
				printMenuHeader();
				continue;
			}

		}
		applicationContext.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Product Catalog");
		System.out.println(productManagementService.getProducts().toString());
	}

	public void createOrder(Scanner sc) {
		Order order = new DefaultOrder();
		String creditCardNumber;
		while (true) {
			System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase.");
			creditCardNumber = sc.next();
			if (order.isCreditCardNumberValid(creditCardNumber)) {
				order.setCreditCardNumber(creditCardNumber);
				order.setProducts(applicationContext.getSessionCart().getProducts());
				order.setCustomerId(applicationContext.getLoggedInUser().getId());
				orderManagementService.addOrder(order);
				System.out.println(
						orderManagementService.getOrdersByUserId(applicationContext.getLoggedInUser().getId()));
				break;
			}
			System.out.println(
					"You entered invalid credit card number. Valid credit card number should contain 16 digits. Please, try one more time.");
			continue;
		}
		System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
	}

}
