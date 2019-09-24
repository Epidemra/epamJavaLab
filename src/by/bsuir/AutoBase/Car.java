package by.bsuir.AutoBase;

/**
 * The type Car.
 */
public class Car extends  Vehicle implements java.io.Serializable{

    /**
     * Instantiates a new Car.
     */
    public Car() {
    }

    private int seatCount;
    private BodyType bodyType;
    private int doorCount;
    private int x;

    /**
     * Gets seat count.
     *
     * @return the seat count
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Sets seat count.
     *
     * @param seatCount the seat count
     */
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    /**
     * Gets body type.
     *
     * @return the body type
     */
    public BodyType getBodyType() {
        return bodyType;
    }

    /**
     * Sets body type.
     *
     * @param bodyType the body type
     */
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * Gets door count.
     *
     * @return the door count
     */
    public int getDoorCount() {
        return doorCount;
    }

    /**
     * Sets door count.
     *
     * @param doorCount the door count
     */
    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
}
