package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.TransactionBO;

public class TransactionDAO implements ITransactionDAO {

	public TransactionBO createTransaction(int trID, String tr_date, int fcc, int tcc, int amnt) {
		// TODO Auto-generated method stub
		
		String sql = "Insert into Transaction values (?, ?, ?, ?, ?)";

        Connection conn = ConnectManager.getInstance().getConnection();
        
        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, trID);
            ps.setString(2, tr_date);
            ps.setInt(3, fcc);
            ps.setInt(4, tcc);
            ps.setInt(5, amnt);

            rs = ps.executeQuery();

            if (rs.next()) {
                TransactionBO tr = new TransactionBO();
                tr.setTransaction_ID(trID);
                tr.setTransaction_Date(tr_date);
                tr.setFrom_Credit_Card(fcc);
                tr.setTo_Credit_Card(tcc);
                tr.setAmmount(amnt);
                return tr;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
		
		return null;
	}

	public TransactionBO getTransaction(int trID) {
		// TODO Auto-generated method stub
		
		 String sql = "select transaction_id, transaction_date, from_credit_card, to_credit_card, ammount from transaction where transaction_id = ?";

	        Connection conn = ConnectManager.getInstance().getConnection();

	        ResultSet rs=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, trID);

	            rs = ps.executeQuery();

	            if (rs.next()) {
	            	TransactionBO tr = new TransactionBO();
	            	tr.setTransaction_ID(rs.getInt("transaction_id"));
	                tr.setTransaction_Date(rs.getString("transaction_date"));
	                tr.setFrom_Credit_Card(rs.getInt("from_credit_card"));
	                tr.setTo_Credit_Card(rs.getInt("to_credit_card"));
	                tr.setAmmount(rs.getInt("ammount"));
	                return tr;
	            } else {
	                return null;
	            }

	        }catch (Exception e){
	            System.out.println(e.getStackTrace());
	        }

			return null;
	}

	public TransactionBO getTransactionbyCC(int accID) {
		// TODO Auto-generated method stub
		
		String sql = "select transaction_id, transaction_date, from_credit_card, to_credit_card, ammount from transaction where from_credit_card in (select credit_card_id from credit_card where account_id = ?)";
		
		Connection conn = ConnectManager.getInstance().getConnection();

        ResultSet rs=null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accID);

            rs = ps.executeQuery();

            if (rs.next()) {
            	TransactionBO tr = new TransactionBO();
            	tr.setTransaction_ID(rs.getInt("transaction_id"));
                tr.setTransaction_Date(rs.getString("transaction_date"));
                tr.setFrom_Credit_Card(rs.getInt("from_credit_card"));
                tr.setTo_Credit_Card(rs.getInt("to_credit_card"));
                tr.setAmmount(rs.getInt("ammount"));
                return tr;
            } else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

		
		return null;
	}


}
