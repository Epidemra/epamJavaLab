package by.bsuir;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.ControllerLayer.Controller;


public class Main {

    public static void main(String[] args) {

        Controller.InitializeAutobase();
        while (true){
            AutoBase.Execute();
        }
    }
}
