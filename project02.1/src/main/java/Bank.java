import java.util.List;

public class Bank {

    private Customer[] customers;

    private int numberOfCustomer;

    public Bank() {

    }

    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
//        customers[numberOfCustomer] = customer;
//        numberOfCustomer++;
        customers[numberOfCustomer++] = customer;
    }

    public int getNumOfCustomers(Customer[] customers) {
       return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomer) {
            return customers[index];

        }

        return null;


    }

}
