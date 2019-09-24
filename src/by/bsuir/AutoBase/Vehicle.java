package by.bsuir.AutoBase;

/**
 * The type Vehicle.
 */
public abstract class Vehicle implements java.io.Serializable{

    private String make;
    private String model;
    private String colour;
    private double price;
    private double fuelConsumption;
    private int power;
    private int year;
    private FuelType fuelType;

    /**
     * Gets make.
     *
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets make.
     *
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets colour.
     *
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets colour.
     *
     * @param colour the colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets fuel consumption.
     *
     * @return the fuel consumption
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Sets fuel consumption.
     *
     * @param fuelConsumption the fuel consumption
     */
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Gets power.
     *
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * Sets power.
     *
     * @param power the power
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Sets fuel type.
     *
     * @param fuelType the fuel type
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}