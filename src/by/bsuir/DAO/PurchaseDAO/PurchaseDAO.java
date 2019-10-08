package by.bsuir.DAO.PurchaseDAO;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.Purchase;
import java.io.*;
import java.util.ArrayList;

/**
 * The type Purchase dao.
 */
public class PurchaseDAO implements IPurchaseDAO {

    private static String filePath = getDatabasePath();

    @SuppressWarnings("unchecked")
    private static ArrayList<Purchase> deserializePurchases(){
        ArrayList<Purchase> purchases = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            purchases = (ArrayList<Purchase>)in.readObject();

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
        return purchases;
    }

    private static void serializePurchases(ArrayList<Purchase> purchases){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(purchases);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void insert(Purchase purchase){
        ArrayList<Purchase> purchases = getPurchases();
        if (purchases == null) {
            purchases = new ArrayList<Purchase>();
        }
        purchases.add(purchase);
        AutoBase.setPurchases(purchases);
        serializePurchases(purchases);
    }

    public ArrayList<Purchase> getPurchases(){
        return deserializePurchases();
    }



    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\purchases.dat";
    }

}
