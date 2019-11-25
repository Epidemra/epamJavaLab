package by.bsuir.DAO.VehicleDAO;

import java.util.ArrayList;
import by.bsuir.AutoBase.Vehicle;

/**
 * The interface Vehicle dao.
 */
public interface IVehicleDAO {

    /**
     * Delete.
     *
     * @param index the index
     */
    void delete(int index);

    /**
     * Insert.
     *
     * @param vehicle the vehicle
     */
    void insert(Vehicle vehicle);

    /**
     * Gets vehicles.
     *
     * @return the vehicles
     */
    ArrayList<Vehicle> getVehicles();
}
