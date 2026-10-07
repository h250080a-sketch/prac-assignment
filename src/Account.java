public abstract class Account {

    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected for account " + accountNumber + ": amount must be positive (got " + amount + ").");
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount + " into account " + accountNumber + ". New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public abstract void withdraw(double amount);


    public abstract void endOfMonth();
}
