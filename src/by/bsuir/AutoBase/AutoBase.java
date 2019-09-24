package by.bsuir.AutoBase;

import java.util.List;

public class AutoBase implements java.io.Serializable{

    private double money;
    private List<Vehicle> carList;

    public int getCarCount() {
        return carList.size();
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Vehicle> getCarList() {
        return carList;
    }

    public void setCarList(List<Vehicle> carList) {
        this.carList = carList;
    }

    public AutoBase() {
    }
}
