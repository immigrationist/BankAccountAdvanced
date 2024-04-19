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
 /*
     add a person class and link the person information with the account
     number it is entered with so when you print all the information
     you receive the information of the account number you assigned with
     the problem was that when we tried to print the person with the account
     the last person that was entered in the system would appear with the
     account details of someone else

        so lets say an account was created and lets set its account number to 123.
        we have all information entered at this point and the owner of the account is JACK.
        now we do everything we want and quit to main menu.
        now we are creating another account but this time with the account number 987.
        the owner of this account is ashley and again we have entered every information.
        after ashley has created her account, we are logging back in jack's account to see his personal information
        and account information. The result comes back with jacks account details and ashley's personal information
        instead of jack's personal information.
     */


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