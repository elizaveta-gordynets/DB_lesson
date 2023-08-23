package service;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {

    final SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public void save(User user) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();

       session.save(user);
       t.commit();
       session.close();
    }

    @Override
    public User getUserById(int id) {
        final Session session = factory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        final Session session = factory.openSession();
        List users = session.createQuery("FROM User").getResultList();
        session.close();
        return users;
    }

    @Override
    public void updateUser(int id) {
        final Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("update User u set username=:username WHERE id=:id");
        query.setParameter("username", "Narcissa");
        query.setParameter("id", id);
        query.executeUpdate();
        t.commit();
        session.clear();
        session.close();
    }

    @Override
    public List<User> findAllNatite() {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<User> retrieved = session.createNativeQuery("Select * from users", User.class).getResultList();
        t.commit();
        session.close();
        return retrieved;
    }


}
