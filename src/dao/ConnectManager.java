package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class ConnectManager {

    private static ConnectManager cmIsntance;
    private static Connection conn ;
    private ConnectManager() {
      
    }

    public static ConnectManager getInstance(){
    if(cmIsntance==null){
        cmIsntance= new ConnectManager();
    }
    return cmIsntance;
    }

    public  Connection getConnection(){
    	Locale.setDefault(Locale.ENGLISH);
        if(conn==null){
            try {
            	String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
                String UserName = "BANK";
                String Password = "systeM2016";
                conn = DriverManager.getConnection(URL, UserName, Password);
            } catch (SQLException e) {
                conn=null;
                System.err.println (e);

            }
        }

        return conn;
    }
}
