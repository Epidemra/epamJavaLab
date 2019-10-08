package by.bsuir.Serialize;

import java.util.ArrayList;

/**
 * The interface Serialize.
 */
public interface ISerialize {

    /**
     * Deserialize array list.
     *
     * @param filePath the file path
     * @return the array list
     */
    ArrayList<Object> deserialize(String filePath);

    /**
     * Serialize.
     *
     * @param filePath the file path
     * @param list     the list
     */
    void serialize(String filePath, ArrayList<Object> list);

}
