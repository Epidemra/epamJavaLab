package by.bsuir.Compare;

import by.bsuir.AutoBase.Vehicle;

import java.util.Comparator;

/**
 * The type Compare by year.
 */
public class CompareByYear implements Comparator<Vehicle> {

    public int compare(Vehicle a, Vehicle b){

        return Integer.compare(a.getYear(), b.getYear());
    }
}
