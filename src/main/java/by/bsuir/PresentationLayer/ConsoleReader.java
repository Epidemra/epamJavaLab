package by.bsuir.PresentationLayer;

import java.util.Scanner;

/**
 * The type Console reader.
 */
public class ConsoleReader {

    private static Scanner in = new Scanner(System.in);

    /**
     * Gets string.
     *
     * @return the string
     */
    public static String getString() {
        return in.nextLine();
    }

    /**
     * Get int int.
     *
     * @return the int
     */
    public static int getInt() { return in.nextInt(); }

    /**
     * Get double double.
     *
     * @return the double
     */
    public static double getDouble(){
        return in.nextDouble();
    }
}
