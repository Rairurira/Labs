package app;

public class AccountBO {
	private int accountID;
    private String firstName;
    private String lastName;
    private String country;

    public int getAccountID() {
        return accountID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCountry() {
        return country;
    }

    public void setAccountID(int accID) {
        accountID = accID;
    }
    public void setFirstName(String fName) {
        firstName = fName;
    }
    public void setLastName(String lName) {
        lastName = lName;
    }
    public void setCountry(String c) {
        country = c;
    }

}
