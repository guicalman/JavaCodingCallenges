import java.util.ArrayList;

public class Branch {
    ArrayList<Customer> customers;

    public Branch() {
        customers=new ArrayList<Customer>();
    }

    public void addNewCustomer(String name, double initialTransaction){
        Customer newCustomer= new Customer(name, initialTransaction);
        customers.add(newCustomer);
    }

    public void addCustomerTransaction(String name, double transactionValue){
        Customer currentCustomer = getCustomer(name);
        currentCustomer.addTransaction(transactionValue);
    }

    private Customer getCustomer(String name) {
        Customer tempCustomer = null;
        for(int i=0; i<customers.size(); i++){
            tempCustomer=customers.get(i);
            if(tempCustomer.getName().equals(name)){
                return tempCustomer;
            }
        }
        return tempCustomer;
    }


}
