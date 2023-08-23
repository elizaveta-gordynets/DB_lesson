import entity.User;
import org.postgresql.gss.GSSOutputStream;
import service.OrderDaoImpl;
import service.UserService;

import java.sql.*;

public class Main {


    public static void main(String[] args) {

        final UserService service = new UserService();
        final OrderDaoImpl orderDao = new OrderDaoImpl();

        //service.saveUser();
      //  service.getAllUsersNativveQuery().forEach(u -> System.out.println(u.getUsername()));
        //System.out.println(service.getById(5));
        //service.updateUserById(5);
        //System.out.println(service.getById(5));
//      service.getAllUsers().forEach(u -> System.out.println(u.getUsername()));
    /*    orderDao.createOrderForUser(2);
        orderDao.getAllOrdersForUser(2).forEach( order -> System.out.println(order.getOrderName()));*/
        orderDao.updateOrderName(1);
        System.out.println(orderDao.findOrderById(1).getOrderName());

    }

}
