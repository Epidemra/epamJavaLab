package by.bsuir.DAO.VehicleDAO;

import java.util.ArrayList;
import by.bsuir.AutoBase.Vehicle;

public interface IVehicleDAO {

    boolean Delete(Vehicle vehicle);
    void Insert(Vehicle vehicle);
    ArrayList<Vehicle> getVehicles();
    /*ArrayList<Vehicle> getBooksByTitle(String title);
    ArrayList<Vehicle> getBooksByAuthor(String author);*/
}
