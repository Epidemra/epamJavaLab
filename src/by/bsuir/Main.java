package by.bsuir;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.ControllerLayer.Controller;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Controller.initializeAutobase();
        while (true){
            AutoBase.execute();
        }
    }
}
