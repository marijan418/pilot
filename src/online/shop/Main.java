package online.shop;

import online.shop.menus.impl.MainMenu;
import online.shop.menus.interfaces.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Menu mainMenu = new MainMenu();
		mainMenu.start();

	}

}
