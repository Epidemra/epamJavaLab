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
    private static ArrayList<Vehicle> DeserializeVehicles(){
        ArrayList<Vehicle> Vehicles = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            Vehicles = (ArrayList<Vehicle>)in.readObject();

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
        return Vehicles;
    }

    /**
     * Serialize vehicles.
     *
     * @param Vehicles the vehicles
     */
    public void SerializeVehicles(ArrayList<Vehicle> Vehicles){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(Vehicles);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void Delete(int index){
        ArrayList<Vehicle> Vehicles = getVehicles();
        if (Vehicles != null){
            Vehicles.remove(index);
            AutoBase.setCarList(Vehicles);
            SerializeVehicles(Vehicles);
        }
    }

    public void Insert(Vehicle vehicle){
        ArrayList<Vehicle> Vehicles = getVehicles();
        if (Vehicles == null) {
            Vehicles = new ArrayList<Vehicle>();
        }
        Vehicles.add(vehicle);
        AutoBase.setCarList(Vehicles);
        SerializeVehicles(Vehicles);
    }

    public ArrayList<Vehicle> getVehicles(){
        return DeserializeVehicles();
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

    /**
     * Get books by author array list.
     *
     * @param author the author
     * @return the array list
     */
    static ArrayList<Vehicle> getBooksByAuthor(String author){
        throw new UnsupportedOperationException();
    }

    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\cars.dat";
    }
}
