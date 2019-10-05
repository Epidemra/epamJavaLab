package by.bsuir.DAO.VehicleDAO;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.Vehicle;

import java.io.*;
import java.util.ArrayList;

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

    private static void SerializeVehicles(ArrayList<Vehicle> Vehicles){
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

    public boolean Delete(Vehicle vehicle){
        throw new UnsupportedOperationException();
    }

    public void Insert(Vehicle vehicle){
        throw new UnsupportedOperationException();
    }

    public ArrayList<Vehicle> getVehicles(){
        return DeserializeVehicles();
    }

    static ArrayList<Vehicle> getBooksByTitle(String title){
        throw new UnsupportedOperationException();
    }

    static ArrayList<Vehicle> getBooksByAuthor(String author){
        throw new UnsupportedOperationException();
    }

    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\cars.dat";
    }



}
