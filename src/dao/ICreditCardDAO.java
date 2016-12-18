package dao;

import app.CreditCardBO;

public interface ICreditCardDAO {
	
	public CreditCardBO createCreditCard( int ccID, String accID, int cash );
    public CreditCardBO getCreditCard( int ccID);
    public CreditCardBO getCreditCardbyAccount(String accID);
    public boolean updateCreditCard( CreditCardBO ccBO);
    public boolean deleteCreditCard( int ccID);

}
