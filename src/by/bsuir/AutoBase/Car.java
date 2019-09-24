package by.bsuir.AutoBase;

public class Car extends  Vehicle implements java.io.Serializable{

    public Car() {
    }

    private int seatCount;
    private BodyType bodyType;
    private int doorCount;
    private int x;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
}
