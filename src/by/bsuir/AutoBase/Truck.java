package by.bsuir.AutoBase;

/**
 * The type Truck.
 */
public class Truck extends Vehicle implements java.io.Serializable{

    /**
     * Instantiates a new Truck.
     */
    public Truck() {
    }

    private int capacity;
    private TruckCategory truckCategory;

    /**
     * Gets truck category.
     *
     * @return the truck category
     */
    public TruckCategory getTruckCategory() {
        return truckCategory;
    }

    /**
     * Sets truck category.
     *
     * @param truckCategory the truck category
     */
    public void setTruckCategory(TruckCategory truckCategory) {
        this.truckCategory = truckCategory;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
