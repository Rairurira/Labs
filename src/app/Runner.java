package app;

import dao.TransactionDAO;

public class Runner {

	public static void main(String[] args) {
		
	        TransactionDAO trDao= new TransactionDAO();
	        	    
	        trDao.createTransaction(3, "11-DEC-16", 248683369, 789361362, 50);

	    }

}
