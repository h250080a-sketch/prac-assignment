public class CurrentAccount extends Account {

    private double overdraftLimit;
    private static final double MONTHLY_MAINTENANCE_FEE = 5.0;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected for current account " + accountNumber + ": amount must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal of " + amount + " rejected for current account " + accountNumber + ": would exceed overdraft limit of " + overdraftLimit + " (current balance: " + balance + ").");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from current account " + accountNumber + ". New balance: " + balance);
    }
    @Override
    public void endOfMonth() {
        balance -= MONTHLY_MAINTENANCE_FEE;
        System.out.println("Month-end maintenance fee deducted from current account " + accountNumber + ": -" + MONTHLY_MAINTENANCE_FEE + ". New balance: " + balance);
    }
}
