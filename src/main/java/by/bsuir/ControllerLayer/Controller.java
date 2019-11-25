package by.bsuir.ControllerLayer;

import by.bsuir.AutoBase.*;
import by.bsuir.DAO.DaoFactory;
import by.bsuir.DBmigrate.DBController;
import by.bsuir.DBmigrate.XMLVerifier;
import by.bsuir.PresentationLayer.View;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Controller.
 */
public class Controller {

    /**
     * Initialize autobase.
     *
     * @throws SQLException the sql exception
     */
    public static void initializeAutobase() throws SQLException {

        String carsXSD =  new File("").getAbsolutePath()+"\\data\\cars.xsd";
        String carsXML =  new File("").getAbsolutePath()+"\\data\\cars.xml";
        XMLVerifier xmlVerifier = new XMLVerifier();
        if (xmlVerifier.validate(new File(carsXML), new File(carsXSD))) {
            AutoBase.setCarList(DaoFactory.getVehicleDAO().getVehicles());
            DBController.getInstance("admin", "root", "jdbc:mysql://localhost:3306/autobase?serverTimezone=Europe/Minsk&useSSL=false").Export(AutoBase.getCarList());
        }
        else{
            System.out.println("Invalid format cars.xml");
            System.exit(0);
        }

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

        if (action == 13){
            View.printAvailableActions();
            action = -1;
        }
        if (action > 8 && AutoBase.getCurrentUser() instanceof Customer){
            action = -1;
            View.showMessage("No roots");
        }
        if (action == 3 && AutoBase.getCurrentUser() instanceof Manager){
            action = -1;
            View.showMessage("U must be a customer");
        }

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
                View.showMessage(counter+":\n"+object.toString());
                counter++;
            }
        }else {
            View.showMessage("Empty list");
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
