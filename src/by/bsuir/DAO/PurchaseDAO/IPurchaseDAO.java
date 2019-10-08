package by.bsuir.DAO.PurchaseDAO;

import by.bsuir.AutoBase.Purchase;
import by.bsuir.AutoBase.User;

import java.util.ArrayList;

public interface IPurchaseDAO {

    void Insert(Purchase purchase);
    ArrayList<Purchase> getPurchases();
}
