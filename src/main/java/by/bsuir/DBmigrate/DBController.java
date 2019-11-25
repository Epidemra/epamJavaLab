package by.bsuir.DBmigrate;

import by.bsuir.AutoBase.Car;
import by.bsuir.AutoBase.Truck;
import by.bsuir.AutoBase.Vehicle;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.util.ArrayList;

/**
 * The type Db controller.
 */
public class DBController {

    private static DBController instance;
    private String _password;
    private String _username;
    private String _url;

    private DBController(String password, String username, String url){
        _password = password;
        _username = username;
        _url = url;
    }

    /**
     * Get instance db controller.
     *
     * @param password the password
     * @param username the username
     * @param url      the url
     * @return the db controller
     */
    public static DBController getInstance(String password, String username, String url){
        if (instance == null){
            return new DBController(password, username, url);
        }
        return instance;
    }

    private static final String PUT_CAR = "INSERT INTO cars (model, make, price, fuelConsumption, power, year, manager, fuelType, seatCount, doorCount, bodyType, capacity, truckCategory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private boolean DBInsert(Vehicle vehicle) throws SQLException {
        boolean result = false;
        /*String password = "admin";
        String username = "root";
        String url = "jdbc:mysql://localhost:3306/autobase?serverTimezone=Europe/Minsk&useSSL=false";*/
        try (Connection conn = DriverManager.getConnection(_url, _username, _password)){
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(PUT_CAR);
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try {
                assert stmt != null;
                stmt.setString(1, vehicle.getModel());
                stmt.setString(2, vehicle.getMake());
                stmt.setDouble(3, vehicle.getPrice());
                stmt.setDouble(4, vehicle.getFuelConsumption());
                stmt.setInt(5, vehicle.getPower());
                stmt.setInt(6, vehicle.getYear());
                stmt.setString(7, vehicle.getManager().getName());
                stmt.setString(8, vehicle.getFuelType().toString());

                if (vehicle instanceof Car){
                    Car car = (Car)vehicle;
                    stmt.setInt(9, car.getSeatCount());
                    stmt.setInt(10, car.getDoorCount());
                    stmt.setString(11, car.getBodyType().toString());
                    stmt.setNull(12, Types.VARCHAR);
                    stmt.setNull(13, Types.VARCHAR);
                }
                else{
                    Truck truck = (Truck)vehicle;
                    stmt.setInt(12, truck.getCapacity());
                    stmt.setString(13, truck.getTruckCategory().toString());
                    stmt.setNull(9, Types.VARCHAR);
                    stmt.setNull(10, Types.VARCHAR);
                    stmt.setNull(11, Types.VARCHAR);
                }

                if (stmt.executeUpdate() == 1) {
                    result = true;
                }

            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
            finally{
                conn.close();
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  result;
    }

    /**
     * Export boolean.
     *
     * @param vehicles the vehicles
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public boolean Export(ArrayList<Vehicle> vehicles) throws SQLException {

        boolean res = true;
        for (Vehicle v:
             vehicles) {
            res &= DBInsert(v);
        }
        return res;
    }
}
