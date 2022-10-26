package DataAccess.Abstracts;

import Entities.Concretes.User;

import java.util.List;

public interface IUserDao {

    void add(User user);
    void delete(User user);
    void update(User user);
    User getUser(String id);
    List<User> getAllUsers();
}
