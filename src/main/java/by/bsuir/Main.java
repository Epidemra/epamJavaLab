package by.bsuir;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.ControllerLayer.Controller;

import java.sql.SQLException;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws SQLException the sql exception
     */
    public static void main(String[] args) throws SQLException {

        Controller.initializeAutobase();
        while (true){
            AutoBase.execute();
        }
    }
}
