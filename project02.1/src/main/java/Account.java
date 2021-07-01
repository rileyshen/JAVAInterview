public class Account {

    private double balance;

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("deposit cash successfully");
        }
    }

    public void withdraw(double amt) {
        if (balance > amt) {
            balance -= amt;
            System.out.println("withdraw money successfully");
        } else {
            System.out.println("Not enough balance for withdrawal");
        }
    }
}
