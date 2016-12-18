package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.CreditCardBO;

public class CreditCardDAO implements ICreditCardDAO {
	
	public CreditCardBO createCreditCard (int ccID, String accID, int cash ){
		String sql = "Insert into Credit_Card values (?, ?, ?)";

        Connection conn = ConnectManager.getInstance().getConnection();
        
        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ccID);
            ps.setString(2, accID);
            ps.setInt(3, cash);
           
            rs = ps.executeQuery();

            if (rs.next()) {
            	CreditCardBO cc = new CreditCardBO();
                cc.setCredit_Card_ID(ccID);
                cc.setAccountID(accID);
                cc.setCash_Amount(cash);
                
                return cc;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return null;

    }

	public CreditCardBO getCreditCard(int ccID) {
		// TODO Auto-generated method stub
		
		String sql = "select credit_card_id, account_id, cash_amount from credit_card where credit_card_id=?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ccID);


            rs = ps.executeQuery();

            if (rs.next()) {
            	CreditCardBO cc = new CreditCardBO();
                cc.setCredit_Card_ID(rs.getInt("credit_card_id"));
                cc.setAccountID(rs.getString("account_id"));
                cc.setCash_Amount(rs.getInt("cash_amount"));
               
                return cc;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

		return null;
	}

	public CreditCardBO getCreditCardbyAccount(String accID) {
		// TODO Auto-generated method stub
		
		String sql = "select credit_card_id, account_id, cash_amount from credit_card where account_id=?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accID);


            rs = ps.executeQuery();

            if (rs.next()) {
            	CreditCardBO cc = new CreditCardBO();
                cc.setCredit_Card_ID(rs.getInt("credit_card_id"));
                cc.setAccountID(rs.getString("account_id"));
                cc.setCash_Amount(rs.getInt("cash_amount"));
               
                return cc;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
		
		return null;
	}

	public boolean updateCreditCard(CreditCardBO ccBO) {
		// TODO Auto-generated method stub
		boolean success= false;

        String sql = "update credit_card set cash_amount where credit_card_id=?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ccBO.getCash_Amount());
           
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

	public boolean deleteCreditCard(int ccID) {
		// TODO Auto-generated method stub
		
		boolean success = false;

        String sql = "delete from credit_card where credit_card_id= ?";

        Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ccID);

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


