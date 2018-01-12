import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initTransaction) {
        this.name = name;
        transactions= new ArrayList<Double>();
        transactions.add(initTransaction);
    }

    public void addTransaction(double transactionValue){
        transactions.add(transactionValue);
    }
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
