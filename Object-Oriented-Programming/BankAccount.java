import java.util.Scanner;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient Balance");
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String holder = sc.nextLine();
        String accNo = sc.nextLine();
        double bal = sc.nextDouble();
        BankAccount account = new BankAccount(holder, accNo, bal);
        account.deposit(sc.nextDouble());
        account.withdraw(sc.nextDouble());
        account.displayBalance();
    }
}
