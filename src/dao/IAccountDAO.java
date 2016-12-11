package dao;

import app.AccountBO;

public interface IAccountDAO {
	
	public AccountBO createAccount( int accID, String fName, String lName, String c );
    public AccountBO getAccount( int accID);
    public AccountBO getAccountbyName(String fName, String lName);
    public boolean updateAccount( AccountBO accBO);
    public boolean deleteAccount( int accID);

}
