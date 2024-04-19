import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Person person = new Person();
        int options = 0;

        while (options != 7) {
            System.out.println("\nBank Operations:");
            System.out.println("1. Create New Account");
            System.out.println("2. Perform Operations in an existing account");
            System.out.println("3. Delete an existing account");
            System.out.println("4. Display the average of all account balances");
            System.out.println("5. Display the maximum and minimum account balances");
            System.out.println("6. Display all accounts that have low balance");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            options = scanner.nextInt();

            switch (options) {
                case 1:
                    // Create New Account
                    System.out.println("\nEnter Information:");
                    System.out.println("Name: ");
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
                    bank.setAccountNumber(scanner.nextDouble());
                    System.out.print("Enter initial balance: ");
                    bank.setBalance(scanner.nextDouble());
                    System.out.println("Enter date created");
                    bank.setDateCreated(scanner.nextInt());
                    System.out.println("Enter withdraw limit");
                    bank.setWithdrawLimit(scanner.nextDouble());
                    bank.addAccount(new Account(bank.getAccountNumber(), bank.getBalance(),
                            bank.getDateCreated(), bank.getWithdrawLimit()));
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    // Perform Operations in an existing account
                    System.out.print("Enter account number: ");
                    int existingAccNumber = scanner.nextInt();
                    Account existingAccount = bank.findAccount(existingAccNumber);

                    if (existingAccount != null) {
                        System.out.println("Account matched to: \n");
                        existingAccount.getAccountInformation();

                        int choice = 0;

                        while (choice != 5) {

                            boolean success;
                            System.out.println("Please choose from 4 of the selections:");
                            System.out.println("1. DEPOSIT MONEY" + "\n2. WITHDRAW MONEY" +
                                    "\n3. CHECK BALANCE" + "\n4. COMPLETE INFORMATION OF ACCOUNT" +
                                    "\n5. QUIT");
                            choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    System.out.println("Enter amount to deposit");
                                    success = existingAccount.depositMoney(scanner.nextInt());
                                    if (success) {
                                        System.out.println("Starting Balance: " + bank.getBalance());
                                        System.out.println("Current Balance: " + existingAccount.getBalance());
                                    } else System.out.println("Invalid Amount!");
                                    break;
                                case 2:
                                    System.out.println("Enter amount, your limit is: " +
                                            existingAccount.getWithdrawLimit());
                                    success = existingAccount.withdrawMoney(scanner.nextInt());
                                    if (success) {
                                        System.out.println("Starting balance: " + bank.getBalance());
                                        System.out.println("Current Balance: " + existingAccount.getBalance());
                                    } else
                                        System.out.println("Limit reached, balance is: " + existingAccount.getBalance());
                                    break;
                                case 3:
                                    System.out.println(existingAccount.getBalance());
                                    break;
                                case 4:
                                    System.out.println("Complete Account Information:");
                              //      existingAccount.getPersonalInformation();
                                //    System.out.println(person);
                                //    existingAccount.getAccountInformation();
                                    existingAccount.print();
                                    break;
                                case 5:
                                    System.out.println("RENDERING INFORMATION...");
                                    break;
                                default:
                            }
                        }
                    }
                    else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number to delete: ");
                    boolean deleted = bank.deleteAccount(scanner.nextInt());
                    if (deleted) {
                        System.out.println("Account deleted successfully!");
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4:
                    System.out.println("Average balance of all accounts: " + bank.getAverageBalance());
                    break;
                case 5:
                    System.out.println("Maximum balance: " + bank.getMaximumBalance());
                    System.out.println("Minimum balance: " + bank.getMinimumBalance());
                    break;
                case 6:
                    System.out.print("Enter balance threshold: ");
                    double balanceThreshold = scanner.nextDouble();
                    ArrayList<Account> lowBalanceAccounts = bank.getLowBalanceAccounts(balanceThreshold);
                    System.out.println("Accounts with balance below " + balanceThreshold + ":");
                    for (Account acc : lowBalanceAccounts) {
                        System.out.println("Account Number: " + acc.getAccountNumber() + ", Balance: " + acc.getBalance());
                    }
                    break;
                case 7:
                    System.out.println("Exiting program...");
                default:
            }
        }
    }
}
