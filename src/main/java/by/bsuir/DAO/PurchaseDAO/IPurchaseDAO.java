package by.bsuir.DAO.PurchaseDAO;

import by.bsuir.AutoBase.Purchase;

import java.util.ArrayList;

/**
 * The interface Purchase dao.
 */
public interface IPurchaseDAO {

    /**
     * Insert.
     *
     * @param purchase the purchase
     */
    void insert(Purchase purchase);

    /**
     * Gets purchases.
     *
     * @return the purchases
     */
    ArrayList<Purchase> getPurchases();
}
