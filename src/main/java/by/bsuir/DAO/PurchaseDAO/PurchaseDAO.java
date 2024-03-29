package by.bsuir.DAO.PurchaseDAO;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.Purchase;
import by.bsuir.Serialize.Serialize;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Purchase dao.
 */
public class PurchaseDAO implements IPurchaseDAO {

    private static String filePath = getDatabasePath();
    private static Serialize<Purchase> serializer = new Serialize<Purchase>();

    public void insert(Purchase purchase){
        ArrayList<Purchase> purchases = getPurchases();
        if (purchases == null) {
            purchases = new ArrayList<Purchase>();
        }
        purchases.add(purchase);
        AutoBase.setPurchases(purchases);
        serializer.serialize(filePath, purchases);
    }

    public ArrayList<Purchase> getPurchases(){
        return serializer.deserialize(filePath);
    }

    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\purchases.xml";//"\\data\\purchases.dat";
    }
}
