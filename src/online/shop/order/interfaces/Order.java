package online.shop.order.interfaces;

import java.util.ArrayList;

import online.shop.product.interfaces.Product;

public interface Order {
	boolean isCreditCardNumberValid(String userInput);

	void setCreditCardNumber(String userInput);

	void setProducts(ArrayList<Product> products);

	void setCustomerId(int customerId);

	int getCustomerId();

}
