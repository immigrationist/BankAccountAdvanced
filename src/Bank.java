import java.io.*;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null; // Account not found
    }

    public boolean deleteAccount(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            accounts.remove(account);
            return true; // Account deleted successfully
        }
        return false; // Account not found
    }

    public double getAverageBalance() {
        if (accounts.isEmpty()) return 0.0;

        double totalBalance = 0.0;
        for (Account acc : accounts) {
            totalBalance += acc.getBalance();
        }
        return totalBalance / accounts.size();
    }

    public double getMaximumBalance() {
        if (accounts.isEmpty()) return 0.0;

        double maxBalance = Double.MIN_VALUE;
        for (Account acc : accounts) {
            maxBalance = Math.max(maxBalance, acc.getBalance());
        }
        return maxBalance;
    }

    public double getMinimumBalance() {
        if (accounts.isEmpty()) return 0.0;

        double minBalance = Double.MAX_VALUE;
        for (Account acc : accounts) {
            minBalance = Math.min(minBalance, acc.getBalance());
        }
        return minBalance;
    }

    public double getAverageDeposits()
    {
        if(accounts.isEmpty()) return 0.0;

        double minDeposit = Double.MAX_VALUE;
        for(Account acc : accounts){
            minDeposit = Math.min(minDeposit, acc.getBalance());
        }
        return minDeposit;
    }
    public ArrayList<Account> getLowBalanceAccounts(double balanceThreshold) {
        ArrayList<Account> lowBalanceAccounts = new ArrayList<>();
        for (Account acc : accounts) {
            if (acc.getBalance() < balanceThreshold) {
                lowBalanceAccounts.add(acc);
            }
        }
        return lowBalanceAccounts;
    }

    public void saveAccountsToFile(String filename) {
        try (FileOutputStream fileOut = new FileOutputStream("/Users/ahmetberky/Documents/BankAccounts");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(accounts);
            System.out.println("Accounts saved to file: " + "/Users/ahmetberky/Documents/BankAccounts" );
        } catch (IOException e) {
            System.out.println("Error saving accounts to file: " + e.getMessage());
        }
    }

    public void loadAccountsFromFile(String filename) {
        try (FileInputStream fileIn = new FileInputStream("/Users/ahmetberky/Documents/BankAccounts");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            accounts = (ArrayList<Account>) objectIn.readObject();
            System.out.println("Accounts loaded from file: " + "/Users/ahmetberky/Documents/BankAccounts");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts from file: " + e.getMessage());
        }
    }
}
