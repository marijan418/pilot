package online.shop.orderManagementService.interfaces;

import java.util.ArrayList;

import online.shop.order.interfaces.Order;

public interface OrderManagementService {
	void addOrder(Order order);

	ArrayList<Order> getOrdersByUserId(int userId);

	ArrayList<Order> getOrders();

}
