package by.bsuir.ControllerLayer;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.FuelType;
import by.bsuir.DAO.DaoFactory;
import by.bsuir.DAO.UserDAO.UserDAO;
import by.bsuir.DAO.VehicleDAO.VehicleDAO;
import by.bsuir.PresentationLayer.View;


public class Controller {

    public static void InitializeAutobase(){
        AutoBase.setCarList(DaoFactory.getVehicleDAO().getVehicles());
        AutoBase.setUsers(DaoFactory.getUserDAO().getUsers());
    }

    public static Object[] authorizeRequest(){
        return View.getUserData();
    }

    public static int chooseActionRequest(){
        int action = View.getAction();

        if (action == 3){
            View.printAvailableActions();
            action = -1;
        }
            /*default:
                notifyUserRequest("Unknown command!");
                break;*/
        /*if (!isAdmin && result>6) {
            notifyUserRequest("You dont have enough root!");
            result = -1;
        }*/
        return action;
    }
}
