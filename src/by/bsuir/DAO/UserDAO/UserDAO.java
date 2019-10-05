package by.bsuir.DAO.UserDAO;

import by.bsuir.AutoBase.AutoBase;
import by.bsuir.AutoBase.User;
import by.bsuir.AutoBase.Vehicle;

import java.io.*;
import java.util.ArrayList;

/**
 * The type User dao.
 */
public class UserDAO implements IUserDAO{

    private static String filePath = getDatabasePath();

    @SuppressWarnings("unchecked")
    private static ArrayList<User> DeserializeUsers(){
        ArrayList<User> Users = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            Users = (ArrayList<User>)in.readObject();

            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return Users;
    }

    private static void SerializeUsers(ArrayList<User> Users){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(Users);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public boolean Delete(User user){
        throw new UnsupportedOperationException();
    }

    public void Insert(User user){
        ArrayList<User> Users = getUsers();
        if (Users == null) {
            Users = new ArrayList<User>();
        }
        Users.add(user);
        AutoBase.setUsers(Users);
        SerializeUsers(Users);
    }

    /**
     * Get user by name user.
     *
     * @param name the name
     * @return the user
     */
    public User getUserByName(String name){
        ArrayList<User> users = DeserializeUsers();
        if (users != null){
            for (User user: users
            ) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        }

        return null;
    }

    public ArrayList<User> getUsers(){
        return DeserializeUsers();
    }

    /**
     * Get books by title array list.
     *
     * @param title the title
     * @return the array list
     */
    static ArrayList<Vehicle> getBooksByTitle(String title){
        throw new UnsupportedOperationException();
    }

    /**
     * Get books by author array list.
     *
     * @param author the author
     * @return the array list
     */
    static ArrayList<Vehicle> getBooksByAuthor(String author){
        throw new UnsupportedOperationException();
    }


    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\users.dat";
    }


}
