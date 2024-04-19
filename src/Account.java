import java.util.ArrayList;

class Account{
    private double accountNumber;
    private double balance;

    private Person accountHolder;
    private int dateCreated;
    private double withdrawMoney;

    private double withdrawLimit;


    public Account(double accountNumber, double balance,
                   int dateCreated, double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateCreated = dateCreated;
        this.withdrawLimit = withdrawLimit;

        withdrawMoney = 0;
    }

    public double getAccountNumber()
    {
        return accountNumber;
    }
    public void setAccountNumber(double accountNumber)
    {
        if(accountNumber > 0)
            this.accountNumber = accountNumber;
    }



    public Person getAccountHolder()
    {
        return accountHolder;
    }

    public void setAccountHolder(Person accountHolder)
    {
        if (accountHolder != null)
            this.accountHolder = accountHolder;
    }

    public int getDateCreated()
    {
        return dateCreated;
    }
    public void setDateCreated(int dateCreated)
    {
        if(dateCreated > 0)
            this.dateCreated = dateCreated;
    }

    public double getBalance()
    {
        return balance;
    }
    public void setBalance(double balance)
    {
        if(balance > 0)
            this.balance = balance;
    }

    public double getWithdrawLimit() {return withdrawLimit;}
    public void setWithdrawLimit(double withdrawLimit)
    {
        if(withdrawLimit > 0)
            this.withdrawLimit = withdrawLimit;
    }

    public boolean withdrawMoney(double newMoney)
    {
        boolean success = false;

        if(balance >= newMoney && withdrawMoney + newMoney <= withdrawLimit)
        {
            balance -= newMoney;
            withdrawMoney += newMoney;
            success = true;
        }

        return  success;
    }

    public boolean depositMoney(double newMoney)
    {
        boolean success;
        if(newMoney > 0) {
            balance += newMoney;
            success = true;
        }
        else success = false;

        return success;
    }

    public void print(){
        System.out.println(" ACCOUNT NUMBER: " + getAccountNumber() +
                "\n DATE CREATED: " + getDateCreated() +
                "\n CURRENT BALANCE: " + getBalance() +
                "\n WITHDRAW LIMIT: " + getWithdrawLimit() + "\n");
                System.out.println(getAccountHolder());
    }

    public void getAccountInformation()
    {
        System.out.println(" ACCOUNT NUMBER: " + getAccountNumber() +
                "\n DATE CREATED: " + getDateCreated() +
                "\n CURRENT BALANCE: " + getBalance() +
                "\n WITHDRAW LIMIT: " + getWithdrawLimit() + "\n");
    }
}