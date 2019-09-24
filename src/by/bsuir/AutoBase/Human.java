package by.bsuir.AutoBase;

public abstract class Human implements java.io.Serializable {

    public Human() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
