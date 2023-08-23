package service;

import entity.User;

import java.util.List;

public class UserService {

   private final UserDaoImpl userDao = new UserDaoImpl();


    public void saveUser() {
        User user = new User();
        user.setUsername("NextUser");
        user.setOrderedSum(200);
        user.setEmail("user@email");
        userDao.save(user);
    }

    public List<User> getAllUsers() {
      return  userDao.findAll();
    }

    public List<User> getAllUsersNativveQuery() {
        return userDao.findAllNatite();
    }

    public User getById(int id) {
        return userDao.getUserById(id);
    }

    public void updateUserById(int id) {
        userDao.updateUser(id);
    }
}
