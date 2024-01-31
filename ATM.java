import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank with some dummy accounts
        Bank bank = new Bank();
        bank.addAccount("123456", "John Doe", 1000);
        bank.addAccount("789012", "Jane Smith", 500);

        // Prompt user for login
        System.out.println("Welcome to the iNeuron ATM");
        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String userPIN = scanner.nextLine();

        // Authenticate user
        AccountHolder user = bank.authenticateUser(userID, userPIN);
        if (user != null) {
            System.out.println("Login Successful!");

            // Display available options
            while (true) {
                System.out.println("\nOptions:");
                System.out.println("1. Show Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        bank.showTransactionHistory(user);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        bank.withdraw(user, withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        bank.deposit(user, depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's account number: ");
                        String recipientAccount = scanner.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        bank.transfer(user, recipientAccount, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using iNeuron ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid User ID or PIN. Please try again.");
        }
    }
}

class AccountHolder {
    private String userID;
    private String userPIN;

    public AccountHolder(String userID, String userPIN) {
        this.userID = userID;
        this.userPIN = userPIN;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPIN() {
        return userPIN;
    }
}

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void transfer(double amount) {
        balance -= amount;
    }
}

class Bank {
    private Account[] accounts;
    private int numAccounts;

    public Bank() {
        accounts = new Account[10];
        numAccounts = 0;
    }

    public void addAccount(String accountNumber, String accountHolderName, double balance) {
        if (numAccounts < accounts.length) {
            accounts[numAccounts] = new Account(accountNumber, accountHolderName, balance);
            numAccounts++;
        } else {
            System.out.println("Cannot add more accounts. Bank is full.");
        }
    }

    public AccountHolder authenticateUser(String userID, String userPIN) {
        // Dummy authentication logic
        if (userID.equals("123") && userPIN.equals("456")) {
            return new AccountHolder(userID, userPIN);
        } else {
            return null;
        }
    }

    public void showTransactionHistory(AccountHolder user) {
        // Dummy method
        System.out.println("Transaction history not available.");
    }

    public void withdraw(AccountHolder user, double amount) {
        // Dummy method
        System.out.println("Withdraw functionality not implemented.");
    }

    public void deposit(AccountHolder user, double amount) {
        // Dummy method
        System.out.println("Deposit functionality not implemented.");
    }

    public void transfer(AccountHolder user, String recipientAccount, double amount) {
        // Dummy method
        System.out.println("Transfer functionality not implemented.");
    }
	}
