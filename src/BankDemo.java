import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 500.0, 100.0));
        accounts.add(new CurrentAccount("CUR-001", 200.0, 300.0));

        System.out.println(" Deposits ");
        accounts.get(0).deposit(50.0);
        accounts.get(1).deposit(-20.0);

        System.out.println("\n Polymorphic withdraw() loop");

        accounts.get(0).withdraw(1000.0);
        accounts.get(1).withdraw(400.0);

        System.out.println("\n Polymorphic endOfMonth() loop ");
        for (Account account : accounts) {
            account.endOfMonth();
        }

        System.out.println("\n Final balances ");
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + ": " + account.getBalance());
        }
    }
}
