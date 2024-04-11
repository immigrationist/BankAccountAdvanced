import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Person person = new Person();
        int accNumber = 0;

        while (true) {
            System.out.println("\nBank Operations:");
            System.out.println("1. Create New Account");
            System.out.println("2. Perform Operations in an existing account");
            System.out.println("3. Delete an existing account");
            System.out.println("4. Display the average of all account balances");
            System.out.println("5. Display the maximum and minimum account balances");
            System.out.println("6. Display all accounts that have low balance");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            int options = scanner.nextInt();

            switch (options) {
                case 1:
                    // Create New Account
                    System.out.println("Enter Information:");
                    System.out.println("\nName: ");
                    person.setName(scanner.next());
                    System.out.println("Gender");
                    person.setGender(scanner.next().charAt(0));
                    System.out.println("Age: ");
                    person.setAge(scanner.nextInt());
                    System.out.println("Phone Number: ");
                    person.setPhoneNumber(scanner.nextInt());
                    System.out.println("Home Address: ");
                    person.setHomeAddress(scanner.next());

                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    System.out.println("Enter date created");
                    int dateCreated = scanner.nextInt();
                    System.out.println("Enter withdraw limit");
                    double withdrawLimit = scanner.nextDouble();
                    bank.addAccount(new Account(accNumber, initialBalance,
                            dateCreated, withdrawLimit));
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    // Perform Operations in an existing account
                    System.out.print("Enter account number: ");
                    int existingAccNumber = scanner.nextInt();
                    Account existingAccount = bank.findAccount(existingAccNumber);
                    if (existingAccount != null) {
                        // Perform operations on existing account
                        while (options != 4)
                        {
                            boolean success = true;
                            System.out.println("Please choose from 4 of the selections:");
                            System.out.println("1. DEPOSIT MONEY" + "\n2. WITHDRAW MONEY" +
                                    "\n3. CHECK BALANCE" + "\n4. QUIT");
                            options = scanner.nextInt();

                            switch (options)
                            {
                                case 1:
                                    System.out.println("Enter amount to deposit");
                                    success = existingAccount.depositMoney(scanner.nextInt());
                                    if (success) {
                                        System.out.println("Current Balance: " + accNumber);
                                        System.out.println("\n" + existingAccount.getBalance());
                                    }
                                    else System.out.println("Invalid Amount!");
                                    break;
                                case 2:
                                    System.out.println("Enter amount, your limit is: " +
                                            existingAccount.getWithdrawLimit());
                                    success = existingAccount.withdrawMoney(scanner.nextInt());
                                    if (success)
                                        System.out.println("Current Balance: " + existingAccount.getBalance());
                                    else
                                        System.out.println("Limit reached, balance is: " + existingAccount.getBalance());
                                    break;
                                case 3:
                                    System.out.println(existingAccount.getBalance());
                                    break;
                                case 4:
                                    System.out.println("RENDERING INFORMATION...");
                                    break;
                                default:
                            }
                        }

                        System.out.println("Account matched to: " + existingAccount);
                        // Implement deposit, withdrawal, etc. operations here
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 3:
                    // Delete an existing account
                    System.out.print("Enter account number to delete: ");
                    int accToDelete = scanner.nextInt();
                    boolean deleted = bank.deleteAccount(accToDelete);
                    if (deleted) {
                        System.out.println("Account deleted successfully!");
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4:
                    // Display the average of all account balances
                    System.out.println("Average balance of all accounts: " + bank.getAverageBalance());
                    System.out.println("Minimum deposit of all accounts: " + bank.getAverageDeposits());
                    break;
                case 5:
                    // Display the maximum and minimum account balances
                    System.out.println("Maximum balance: " + bank.getMaximumBalance());
                    System.out.println("Minimum balance: " + bank.getMinimumBalance());
                    break;
                case 6:
                    // Display all accounts that have low balance
                    System.out.print("Enter balance threshold: ");
                    double balanceThreshold = scanner.nextDouble();
                    ArrayList<Account> lowBalanceAccounts = bank.getLowBalanceAccounts(balanceThreshold);
                    System.out.println("Accounts with balance below " + balanceThreshold + ":");
                    for (Account acc : lowBalanceAccounts) {
                        System.out.println("Account Number: " + acc.getAccountNumber() + ", Balance: " + acc.getBalance());
                    }
                    break;
                case 7:
                    // Quit
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }
    }
}
