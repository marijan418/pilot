package online.shop.cart.interfaces;

import java.util.ArrayList;

import online.shop.product.interfaces.Product;

public interface Cart {
	boolean isEmpty();

	void addProduct(Product productById);

	ArrayList<Product> getProducts();

	void clear();

}
