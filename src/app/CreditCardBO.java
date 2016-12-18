package app;

public class CreditCardBO {
	private int credit_card_ID;
    private String account_ID;
    private int cash_amount;
    
    public int getCredit_Card_ID() {
        return credit_card_ID;
    }
    public String getAccountID() {
        return account_ID;
    }
    public int getCash_Amount() {
        return cash_amount;
    }
    
    public void setCredit_Card_ID(int ccID) {
        credit_card_ID = ccID;
    }
    
    public void setAccountID(String accID) {
        account_ID = accID;
    }
    
    public void setCash_Amount(int cash) {
        cash_amount = cash;
    }
    
}
