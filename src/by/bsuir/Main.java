package by.bsuir;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.Car;
import by.bsuir.AutoBase.Truck;
import by.bsuir.AutoBase.Vehicle;
import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        AutoBase cd = new AutoBase();

        ArrayList<Vehicle> lidst = new ArrayList<Vehicle>();

        lidst.add(new Car());
        lidst.add(new Car());
       // lidst.add(new Truck());
        cd.setCarList(lidst);

        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("1.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(cd);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }


        cd = null;

        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("1.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            cd = (AutoBase)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("size = " + cd.getCarList().size());
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}
