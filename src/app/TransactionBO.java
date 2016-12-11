package app;

public class TransactionBO {
	
	private int transaction_ID;
    private String transaction_date;
    private int from_credit_card;
    private int to_credit_card;
    private int ammount;
    
    public int getTransaction_ID() {
        return transaction_ID;
    }
    public String getTransaction_Date() {
        return transaction_date;
    }
    public int getFrom_Credit_Card() {
        return from_credit_card;
    }
    public int getTo_Credit_Card() {
        return to_credit_card;
        
    }public int getAmmount() {
        return ammount;
    }
    
    public void setTransaction_ID(int trID) {
    	transaction_ID = trID;
    }
    
    public void setTransaction_Date(String tr_date) {
    	transaction_date = tr_date;
    }
    
    public void setFrom_Credit_Card(int fcc) {
    	from_credit_card = fcc;
    }
    
    public void setTo_Credit_Card(int tcc) {
    	to_credit_card = tcc;
    }
    
    public void setAmmount(int amnt) {
    	ammount = amnt;
    }
    

}
