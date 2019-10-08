package by.bsuir.DAO.VehicleDAO;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.Vehicle;
import by.bsuir.DAO.DaoFactory;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Vehicle dao.
 */
public class VehicleDAO implements IVehicleDAO {

    private static String filePath = getDatabasePath();

    @SuppressWarnings("unchecked")
    private static ArrayList<Vehicle> deserializeVehicles(){
        ArrayList<Vehicle> vehicles = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            vehicles = (ArrayList<Vehicle>)in.readObject();

            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return vehicles;
    }

    /**
     * Serialize vehicles.
     *
     * @param vehicles the vehicles
     */
    public void serializeVehicles(ArrayList<Vehicle> vehicles){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(vehicles);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void delete(int index){
        ArrayList<Vehicle> vehicles = getVehicles();
        if (vehicles != null){
            vehicles.remove(index);
            AutoBase.setCarList(vehicles);
            serializeVehicles(vehicles);
        }
    }

    public void insert(Vehicle vehicle){
        ArrayList<Vehicle> vehicles = getVehicles();
        if (vehicles == null) {
            vehicles = new ArrayList<Vehicle>();
        }
        vehicles.add(vehicle);
        AutoBase.setCarList(vehicles);
        serializeVehicles(vehicles);
    }

    public ArrayList<Vehicle> getVehicles(){
        return deserializeVehicles();
    }

    /**
     * Get vehicles by year array list.
     *
     * @param year the year
     * @return the array list
     */
    public ArrayList<Vehicle> getVehiclesByYear(int year){
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();
        ArrayList<Vehicle> resVehicles = new ArrayList<Vehicle>();
        for (Vehicle vehicle:
             vehicles) {
            if (vehicle.getYear() == year)
                resVehicles.add(vehicle);
        }
        return resVehicles;
    }

    /**
     * Get vehicles by make array list.
     *
     * @param make the make
     * @return the array list
     */
    public ArrayList<Vehicle> getVehiclesByMake(String make){
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();
        ArrayList<Vehicle> resVehicles = new ArrayList<Vehicle>();
        for (Vehicle vehicle:
                vehicles) {
            if (vehicle.getMake().toLowerCase().equals(make.toLowerCase()))
                resVehicles.add(vehicle);
        }
        return resVehicles;
    }


    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\cars.dat";
    }
}
