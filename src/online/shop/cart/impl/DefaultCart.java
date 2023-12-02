package online.shop.cart.impl;

import java.util.ArrayList;

import online.shop.cart.interfaces.Cart;
import online.shop.product.interfaces.Product;

public class DefaultCart implements Cart {

	private ArrayList<Product> products;

	{
		products = new ArrayList<Product>();
	}

	@Override
	public boolean isEmpty() {
		if (this.products.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public void addProduct(Product productById) {
		this.products.add(productById);
	}

	@Override
	public ArrayList<Product> getProducts() {
		return this.products;
	}

	@Override
	public void clear() {
		this.products.clear();
	}

}
