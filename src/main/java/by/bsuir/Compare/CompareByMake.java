package by.bsuir.Compare;

import by.bsuir.AutoBase.Vehicle;

import java.util.Comparator;

/**
 * The type Compare by make.
 */
public class CompareByMake implements Comparator<Vehicle> {

    public int compare(Vehicle a, Vehicle b){

        return a.getMake().compareTo(b.getMake());
    }
}
