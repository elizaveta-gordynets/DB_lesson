package service;

import entity.Product;
import entity.User;
import entity.UserOrders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    final SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public List<UserOrders> getAllOrdersForUser(int userId) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List retrieved = session.createQuery("FROM UserOrders uo WHERE uo.user.id = :userId ")
                .setParameter("userId", userId)
                .getResultList();
        t.commit();
        session.close();
        return retrieved;
    }

    @Override
    public List<Product> getAllProductsForOrder(int orderId) {
        return null;
    }

    @Override
    public void createOrderForUser(int userId) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        User retrieved = session.load(User.class, userId);
        List<Product> ordered = List.of(Product.builder().productName("Unknown Book")
                .build(), Product.builder().productName("Moidodyr").build());
        ordered.forEach(o -> session.save("Product", o));
        UserOrders order = new UserOrders();
        order.setOrderName("Number 7");
        order.setProducts(ordered);
        order.setUser(retrieved);
        session.save("UserOrders", order);
        t.commit();
        session.close();
    }

    @Override
    public void updateOrderName(int orderId) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        UserOrders order = session.get(UserOrders.class, orderId);
        order.setOrderName("N2");
        session.update(order);
        t.commit();
        session.close();
    }

    @Override
    public UserOrders findOrderById(int orderId) {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        UserOrders retrieved = session.get(UserOrders.class, orderId);
        t.commit();
        session.close();
        return retrieved;
    }
}
