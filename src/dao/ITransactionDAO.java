package dao;


import app.TransactionBO;

public interface ITransactionDAO {
	
	public TransactionBO createTransaction( int trID, String tr_date, int fcc, int tcc, int amnt );
    public TransactionBO getTransaction( int trID);
    public TransactionBO getTransactionbyCC(int accID);
   
}
