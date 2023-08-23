package service;

import entity.Product;
import entity.UserOrders;

import java.util.List;

public interface OrderDao {

    List<UserOrders> getAllOrdersForUser(int userId);
    List<Product> getAllProductsForOrder(int orderId);
    void createOrderForUser(int userId);
    void updateOrderName(int orderId);
    UserOrders findOrderById(int orderId);
}
