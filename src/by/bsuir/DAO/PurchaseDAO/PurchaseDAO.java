package by.bsuir.DAO.PurchaseDAO;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.Purchase;
import java.io.*;
import java.util.ArrayList;

public class PurchaseDAO implements IPurchaseDAO {

    private static String filePath = getDatabasePath();

    @SuppressWarnings("unchecked")
    private static ArrayList<Purchase> DeserializePurchases(){
        ArrayList<Purchase> Purchases = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            Purchases = (ArrayList<Purchase>)in.readObject();

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
        return Purchases;
    }

    private static void SerializePurchases(ArrayList<Purchase> Purchases){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(Purchases);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void Insert(Purchase purchase){
        ArrayList<Purchase> Purchases = getPurchases();
        if (Purchases == null) {
            Purchases = new ArrayList<Purchase>();
        }
        Purchases.add(purchase);
        AutoBase.setPurchases(Purchases);
        SerializePurchases(Purchases);
    }

    public ArrayList<Purchase> getPurchases(){
        return DeserializePurchases();
    }



    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\purchases.dat";
    }

}
