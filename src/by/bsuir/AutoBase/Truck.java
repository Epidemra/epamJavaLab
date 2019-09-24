package by.bsuir.AutoBase;

public class Truck extends Vehicle implements java.io.Serializable{

    public Truck() {
    }

    private int capacity;
    private TruckCategory truckCategory;

    public TruckCategory getTruckCategory() {
        return truckCategory;
    }

    public void setTruckCategory(TruckCategory truckCategory) {
        this.truckCategory = truckCategory;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
