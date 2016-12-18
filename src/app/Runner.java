package app;

import dao.AccountDAO;

public class Runner {

	public static void main(String[] args) {

		AccountDAO accDao= new AccountDAO();
		AccountBO acc = new AccountBO();
		acc.setAccountID("1234");
		acc.setLastName("Ivanov");
		acc.setFirstName("Ivan");
		acc.setCountry("BY");

		acc = accDao.createAccount(acc.getAccountID(), acc.getFirstName(), acc.getLastName(), acc.getCountry());
	    }

}
