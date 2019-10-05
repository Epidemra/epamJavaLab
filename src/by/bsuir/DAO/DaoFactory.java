package by.bsuir.DAO;

import by.bsuir.DAO.UserDAO.UserDAO;
import by.bsuir.DAO.VehicleDAO.VehicleDAO;

public class DaoFactory {

    private static UserDAO userDao = new UserDAO();

    private static VehicleDAO vehicleDAO = new VehicleDAO();

    public static UserDAO getUserDAO()
    {
        return userDao;
    }


    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }
}
