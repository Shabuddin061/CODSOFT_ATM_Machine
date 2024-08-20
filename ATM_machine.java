import java.util.Scanner;

public class ATM_machine {
    private BankAccount account;

    public ATM_machine(BankAccount account) {
        this.account = account;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nAutomated Teller Machine");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawCash();
                    break;
                case 2:
                    depositCash();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM...");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private void withdrawCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Please collect your cash.");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    private void depositCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful! Your new balance is: " + account.getBalance());
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance of $1000
        ATM_machine atm = new ATM_machine(account);
        atm.run();
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
}
}
