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
    private static ArrayList<User> deserializeUsers(){
        ArrayList<User> users = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            users = (ArrayList<User>)in.readObject();

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
        return users;
    }

    private static void serializeUsers(ArrayList<User> users){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(users);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public boolean delete(User user){
        throw new UnsupportedOperationException();
    }

    public void insert(User user){
        ArrayList<User> users = getUsers();
        if (users == null) {
            users = new ArrayList<User>();
        }
        users.add(user);
        AutoBase.setUsers(users);
        serializeUsers(users);
    }

    /**
     * Get user by name user.
     *
     * @param name the name
     * @return the user
     */
    public User getUserByName(String name){
        ArrayList<User> users = deserializeUsers();
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
        return deserializeUsers();
    }


    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\users.dat";
    }


}
