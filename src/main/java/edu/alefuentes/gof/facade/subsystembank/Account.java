package edu.alefuentes.gof.facade.subsystembank;

/**
 * Bank account
 */
public class Account {

    private int accountId;
    private double balance;

    public Account(int accountId, double initialBalance){
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    /**
     * Method to check account balance
     * @return
     */
    public double checkBalance(){
        return balance;
    }

    /**
     * Method to deposit money
     * @param amount
     */
    public void deposit(double amount){
        balance += amount;
        System.out.println(String.format("[ACCOUNT-INFO] - deposited R$%.2f to account %d", amount, accountId));
    }

    /**
     * Method to withdraw money
     * @param amount
     */
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println(String.format("[ACCOUNT-INFO] - withdraw R$%.2f from account %d", amount, accountId));
        }
        else {
            System.out.println(String.format("[ACCOUNT-WARNING] - Insufficient balance in account %d", amount, accountId));

        }
    }
}
