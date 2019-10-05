package by.bsuir.AutoBase;

import by.bsuir.ControllerLayer.Controller;
import by.bsuir.DAO.DaoFactory;
import by.bsuir.DAO.UserDAO.UserDAO;
import by.bsuir.PresentationLayer.View;

import java.util.ArrayList;

/**
 * The type Auto base.
 */
public class AutoBase implements java.io.Serializable{

    private static double money;
    private static User currentUser;
    private static ArrayList<Vehicle> carList;
    private static ArrayList<User> users;

    public static double getMoney() {
        return money;
    }

    public static void setMoney(double money) {
        AutoBase.money = money;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        AutoBase.currentUser = currentUser;
        if (currentUser != null){
            View.ShowMessage("Current user's name: " + AutoBase.getCurrentUser().getName());
        }
        else{
            View.ShowMessage("Logged out");
        }
    }

    public static ArrayList<Vehicle> getCarList() {
        return carList;
    }

    public static void setCarList(ArrayList<Vehicle> carList) {
        AutoBase.carList = carList;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        AutoBase.users = users;
    }

    /**
     * Instantiates a new Auto base.
     */
    public AutoBase() {
    }

    public static void Execute(){
        boolean flag = false;
        do {
            Object[] result = Controller.authorizeRequest();
            User user = null;

            if ((int)result[0] == 1){
                user = new Manager();
            }
            else{
                user = new Customer();
            }

            user.setName((String)result[1]);
            user.setPassword((String)result[2]);

            User registeredUser = DaoFactory.getUserDAO().getUserByName((String)result[1]);

            if (registeredUser == null) {
                DaoFactory.getUserDAO().Insert(user);
                flag = true;
                AutoBase.setCurrentUser(user);
            }
            else{
                if (registeredUser.getPassword().equals((String)result[2])){
                    flag = true;
                    AutoBase.setCurrentUser(user);
                }else {
                    View.ShowMessage("Not correct password\n");
                }
            }
        }while (!flag);

        ChooseActionLoop();
    }

    public static void ChooseActionLoop(){
        boolean flag = true;

        while (flag) {
            int action = Controller.chooseActionRequest();
            switch (action) {
                case 1:
                    System.exit(0);
                    break;
                case 2:
                    flag = false;
                    logOut();
                    break;
            }
        }
    }

    private static void logOut(){
        AutoBase.setCurrentUser(null);
    }
}
