package by.bsuir.AutoBase;

import java.util.List;

/**
 * The type Auto base.
 */
public class AutoBase implements java.io.Serializable{

    private double money;
    private List<Vehicle> carList;

    /**
     * Gets car count.
     *
     * @return the car count
     */
    public int getCarCount() {
        return carList.size();
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public double getMoney() {
        return money;
    }

    /**
     * Sets money.
     *
     * @param money the money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Gets car list.
     *
     * @return the car list
     */
    public List<Vehicle> getCarList() {
        return carList;
    }

    /**
     * Sets car list.
     *
     * @param carList the car list
     */
    public void setCarList(List<Vehicle> carList) {
        this.carList = carList;
    }

    /**
     * Instantiates a new Auto base.
     */
    public AutoBase() {
    }
}
