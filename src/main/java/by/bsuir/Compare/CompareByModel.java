package by.bsuir.Compare;

import by.bsuir.AutoBase.Vehicle;

import java.util.Comparator;

/**
 * The type Compare by model.
 */
public class CompareByModel implements Comparator<Vehicle> {

    public int compare(Vehicle a, Vehicle b){

        return a.getModel().compareTo(b.getModel());
    }
}