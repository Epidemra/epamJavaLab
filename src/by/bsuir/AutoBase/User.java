package by.bsuir.AutoBase;

/**
 * The type Human.
 */
public abstract class User implements java.io.Serializable {

    /**
     * Instantiates a new Human.
     */
    public User() {
    }

    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
