package online.shop.order.impl;

import java.util.ArrayList;

import online.shop.order.interfaces.Order;
import online.shop.product.interfaces.Product;

public class DefaultOrder implements Order {

	private String creditCardNumber;
	private ArrayList<Product> products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String userInput) {
		char[] userInputToChar = userInput.toCharArray();
		if (userInputToChar.length != 16) {
			return false;
		}
		for (char oneChar : userInputToChar) {
			if (!(Character.isDigit(oneChar))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void setCreditCardNumber(String userInput) {
		this.creditCardNumber = userInput;
	}

	@Override
	public void setProducts(ArrayList<Product> products) {
		this.products = new ArrayList<Product>(products);
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public String toString() {
		return String.format("Credit card number: ************%s\nProducts: %s.", creditCardNumber.substring(12),
				products);
	}

}
