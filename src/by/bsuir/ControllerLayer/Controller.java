package by.bsuir.ControllerLayer;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.Customer;
import by.bsuir.DAO.DaoFactory;
import by.bsuir.PresentationLayer.View;

import java.util.ArrayList;


/**
 * The type Controller.
 */
public class Controller {

    /**
     * Initialize autobase.
     */
    public static void InitializeAutobase(){
        AutoBase.setCarList(DaoFactory.getVehicleDAO().getVehicles());
        AutoBase.setUsers(DaoFactory.getUserDAO().getUsers());
    }

    /**
     * Authorize request object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] authorizeRequest(){
        return View.getUserData();
    }

    /**
     * Choose action request int.
     *
     * @return the int
     */
    public static int chooseActionRequest(){
        int action = View.getAction();

        //here ogranicheniya
        if (action == 12){
            View.printAvailableActions();
            action = -1;
        }
        if (action > 4 && AutoBase.getCurrentUser() instanceof Customer){
            action = -1;
            View.ShowMessage("No roots");
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

    /**
     * Add vehicle request object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] addVehicleRequest(){
        return View.getVehicleData();
    }

    /**
     * Print list request.
     *
     * @param list the list
     */
    public static void printListRequest(ArrayList<Object> list){
        int counter = 1;

        if (list != null && list.size() != 0){
            for (Object object : list) {
                View.ShowMessage(counter+":\n"+object.toString());
                counter++;
            }
        }else {
            View.ShowMessage("No cars in list");
        }
    }

    /**
     * Get vehicle request int.
     *
     * @return the int
     */
    public static int getVehicleRequest(){
        return View.getIndex();
    }
}
