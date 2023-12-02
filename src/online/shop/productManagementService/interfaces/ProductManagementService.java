package online.shop.productManagementService.interfaces;

import java.util.ArrayList;

import online.shop.product.interfaces.Product;

public interface ProductManagementService {
	ArrayList<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}
