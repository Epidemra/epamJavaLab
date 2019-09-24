package by.bsuir.AutoBase;

/**
 * The type Human.
 */
public abstract class Human implements java.io.Serializable {

    /**
     * Instantiates a new Human.
     */
    public Human() {
    }

    private String name;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
