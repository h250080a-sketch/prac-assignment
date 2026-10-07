public class SavingsAccount extends Account {

    private double minimumBalance;
    private static final double INTEREST_RATE = 0.03;

    public SavingsAccount(String accountNumber, double balance, double minimumBalance) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected for savings account " + accountNumber + ": amount must be positive.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal of " + amount + " rejected for savings account " + accountNumber + ": balance cannot go below the minimum balance of " + minimumBalance + " (current balance: " + balance + ").");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from savings account " + accountNumber + ". New balance: " + balance);
    }

    @Override
    public void endOfMonth() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Month-end interest applied to savings account " + accountNumber + ": +" + interest + ". New balance: " + balance);
    }
}
