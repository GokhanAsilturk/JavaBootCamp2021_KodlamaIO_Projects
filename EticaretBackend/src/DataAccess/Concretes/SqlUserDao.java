package DataAccess.Concretes;

import DataAccess.Abstracts.IUserDao;
import Entities.Concretes.User;

import java.util.ArrayList;
import java.util.List;

public class SqlUserDao implements IUserDao {

    private List<User> SqlUsers=new ArrayList<>();

    @Override
    public void add(User user) {
        System.out.println("User (ID: "+user.getId()+") add to DB with SQL");
        SqlUsers.add(user);
    }

    @Override
    public void delete(User user) {
        System.out.println("User (ID: "+user.getId()+") deleted from DB with SQL");
        SqlUsers.remove(user);
    }

    @Override
    public void update(User user) {
        System.out.println("User (ID: "+user.getId()+") updated on DB with SQL");
    }

    @Override
    public User getUser(String id) {
        boolean situation = false;
       User user = null;
        for (User tempUser : SqlUsers){
            if (tempUser.getId().equals(id)){
                return tempUser;
            }
        }return null;




    }

    @Override
    public List<User> getAllUsers() {
        return SqlUsers;
    }

    public List<User> getSqlUsers() {
        return SqlUsers;
    }

    public void setSqlUsers(List<User> SqlUsers) {
        this.SqlUsers = SqlUsers;
    }
}
