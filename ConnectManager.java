package lab1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Polskaya on 06.11.2016.
 */
public class ConnectManager {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    private static final String UserName = "BANK";
    private static final String Password = "systeM2016";

    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, UserName, Password);
        } catch (SQLException e) {
            System.err.println ("Connection is missing!");
        }
    }
}
