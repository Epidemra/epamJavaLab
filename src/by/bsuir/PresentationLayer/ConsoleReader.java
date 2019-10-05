package by.bsuir.PresentationLayer;

import java.util.Scanner;

public class ConsoleReader {

    private static Scanner in = new Scanner(System.in);

    public static String getString() {
        return in.nextLine();
    }

    public static int getInt(){
        /*while (!in.hasNextInt()){
            System.out.println("\nYou can input only numbers\n");
        }*/
        return in.nextInt();
    }
}
