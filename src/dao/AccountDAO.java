package dao;

import app.AccountBO;

import java.sql.*;

public class AccountDAO implements IAccountDAO {


    public AccountBO createAccount(String accID, String fName, String lName, String c) {
        String sql = "Insert into Account values (?, ?, ?, ?)";

        Connection conn = ConnectManager.getInstance().getConnection();
        
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accID);
            ps.setString(2, fName);
            ps.setString(3, lName);
            ps.setString(4, c);

            rs = ps.executeQuery();

            if (rs.next()) {
                AccountBO acc = new AccountBO();
                acc.setAccountID(accID);
                acc.setLastName(lName);
                acc.setFirstName(fName);
                acc.setCountry(c);
                return acc;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return null;

    }

    public AccountBO getAccount(String accID) {
        String sql = "select account_id,first_name,last_name,country from account where account_id=?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accID);


            rs = ps.executeQuery();

            if (rs.next()) {
                AccountBO acc = new AccountBO();
                acc.setAccountID(rs.getString("account_id"));
                acc.setLastName(rs.getString("last_name"));
                acc.setFirstName(rs.getString("first_name"));
                acc.setCountry(rs.getString("country"));
                return acc;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return null;

    }

    public AccountBO getAccountbyName(String fName, String lName) {
        String sql = "select first_name,last_name from account where first_name=? and last_name=?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);


            rs = ps.executeQuery();

            if (rs.next()) {
                AccountBO acc = new AccountBO();
                acc.setLastName(rs.getString("last_name"));
                acc.setFirstName(rs.getString("first_name"));
                return acc;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return null;

    }


    public boolean updateAccount(AccountBO accBO) {
        boolean success= false;

        String sql = "update account set last_name=?, first_name=?, country=? where account_id=?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accBO.getLastName());
            ps.setString(2, accBO.getFirstName());
            ps.setString(3, accBO.getCountry());
            ps.setString(4, accBO.getAccountID());

            rs = ps.executeQuery();

            if (rs.next()) {
                success = true;
            } else {

            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
            success = false;
        }

        return success;
    }


    public boolean deleteAccount(String accID) {
        boolean success = false;

        String sql = "delete from account where account_id= ?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accID);

            rs = ps.executeQuery();

            if (rs.next()) {
                success = true;
            } else {

            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
            success = false;
        }

        return success;
    }

	
}

