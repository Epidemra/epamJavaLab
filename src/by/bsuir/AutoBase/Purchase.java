package by.bsuir.AutoBase;

import by.bsuir.ControllerLayer.Controller;
import by.bsuir.DAO.DaoFactory;

import java.util.ArrayList;

public class Purchase implements java.io.Serializable{

    private User customer;
    private Vehicle vehicle;

    public Purchase() {
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public static void addPurchase(Purchase purchase){
        DaoFactory.getPurchaseDAO().Insert(purchase);
    }

    public static void getPurchases(){
        ArrayList<Object> purchases = new ArrayList<Object>();
        if (DaoFactory.getPurchaseDAO().getPurchases() != null)
            purchases.addAll(DaoFactory.getPurchaseDAO().getPurchases());

        Controller.printListRequest(purchases);
    }

    @Override
    public String toString() {
        return  "\n Vehicle:" + vehicle.toString() +
                "\n Customer: " + customer.getName();
    }

}
