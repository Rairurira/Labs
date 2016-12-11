package dao;

import app.CreditCardBO;

public interface ICreditCardDAO {
	
	public CreditCardBO createCreditCard( int ccID, int accID, int cash );
    public CreditCardBO getCreditCard( int ccID);
    public CreditCardBO getCreditCardbyAccount(int accID);
    public boolean updateCreditCard( CreditCardBO ccBO);
    public boolean deleteCreditCard( int ccID);

}
