package edu.alefuentes.gof.facade;

import edu.alefuentes.gof.facade.subsystembank.Account;
import edu.alefuentes.gof.facade.subsystembank.CustomerSupport;
import edu.alefuentes.gof.facade.subsystembank.TransactionProcessor;

public class Bank {

    private Account account;
    private TransactionProcessor transactionProcessor;
    private CustomerSupport customerSupport;

    public Bank(Account account, TransactionProcessor transactionProcessor, CustomerSupport customerSupport){
        this.account = account;
        this.transactionProcessor = transactionProcessor;
        this.customerSupport = customerSupport;
    }

    public double checkBalance(){
        return account.checkBalance();
    }

    public void deposit(double amount){
        account.deposit(amount);
    }

    public void withdraw(double amount){
        account.withdraw(amount);
    }

    public void processTransactioon(int accountId, double amount){
        transactionProcessor.proccessTransaction(accountId, amount);
    }

    public void handleQuery(String query){
        customerSupport.logQuery(query);
        customerSupport.resolveQuery(query);
    }


}
