package by.bsuir.DAO.UserDAO;

import by.bsuir.AutoBase.User;

import java.util.ArrayList;

public interface IUserDAO {

    boolean Delete(User user);
    void Insert(User user);
    ArrayList<User> getUsers();
    /*ArrayList<User> getBooksByTitle(String title);
    ArrayList<User> getBooksByAuthor(String author);*/
}
