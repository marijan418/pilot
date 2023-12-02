package online.shop.orderManagementService;

import java.util.ArrayList;

import online.shop.order.interfaces.Order;
import online.shop.orderManagementService.interfaces.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static DefaultOrderManagementService orderManagementService;
	private ArrayList<Order> orders;

	{
		orders = new ArrayList<Order>();
	}

	@Override
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public ArrayList<Order> getOrdersByUserId(int userId) {
		ArrayList<Order> ordersByUserId = new ArrayList<Order>();
		for (Order order : orders) {
			if (order.getCustomerId() == userId) {
				ordersByUserId.add(order);
			}
		}
		return ordersByUserId;
	}

	@Override
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public static DefaultOrderManagementService getInstance() {
		if (orderManagementService == null) {
			System.out.println("orderManagementService was null");
			orderManagementService = new DefaultOrderManagementService();
		} else {
			System.out.println("orderManagementService was not null");
			System.out.println(orderManagementService.orders);
		}
		return orderManagementService;
	}

	@Override
	public String toString() {
		return String.format("Orders: %s", orders);
	}

	public void clear() {
		this.orders.clear();
	}

}
