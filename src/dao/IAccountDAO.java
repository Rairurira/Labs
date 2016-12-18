package dao;

import app.AccountBO;

public interface IAccountDAO {
	
	public AccountBO createAccount( String accID, String fName, String lName, String c );
    public AccountBO getAccount( String accID);
    public AccountBO getAccountbyName(String fName, String lName);
    public boolean updateAccount( AccountBO accBO);
    public boolean deleteAccount( String accID);

}
