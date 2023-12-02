package online.shop.product.impl;

import online.shop.product.interfaces.Product;

public class DefaultProduct implements Product {

	private int id;
	private String productName;
	private String categoryName;
	private double price;

	public DefaultProduct(int id, String productName, String categoryName, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public String toString() {
		return String.format("Product id: %d\nProduct name: %s\nCategory name: %s\nPrice: %f", id, productName,
				categoryName, price);
	}

}
