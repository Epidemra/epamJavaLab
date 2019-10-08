package by.bsuir.DAO;

import by.bsuir.AutoBase.Purchase;
import by.bsuir.DAO.PurchaseDAO.PurchaseDAO;
import by.bsuir.DAO.UserDAO.UserDAO;
import by.bsuir.DAO.VehicleDAO.VehicleDAO;

/**
 * The type Dao factory.
 */
public class DaoFactory {

    private static UserDAO userDao = new UserDAO();

    private static VehicleDAO vehicleDAO = new VehicleDAO();

    private static PurchaseDAO purchaseDAO = new PurchaseDAO();

    /**
     * Gets user dao.
     *
     * @return the user dao
     */
    public static UserDAO getUserDAO()
    {
        return userDao;
    }


    /**
     * Gets vehicle dao.
     *
     * @return the vehicle dao
     */
    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }

    public static PurchaseDAO getPurchaseDAO(){ return purchaseDAO; }
}
