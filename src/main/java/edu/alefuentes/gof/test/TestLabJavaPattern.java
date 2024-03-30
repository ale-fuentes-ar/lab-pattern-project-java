package edu.alefuentes.gof.test;

import edu.alefuentes.gof.facade.Bank;
import edu.alefuentes.gof.facade.subsystembank.Account;
import edu.alefuentes.gof.facade.subsystembank.CustomerSupport;
import edu.alefuentes.gof.facade.subsystembank.TransactionProcessor;
import edu.alefuentes.gof.msg.MyLogger;
import edu.alefuentes.gof.msg.TypeLog;
import edu.alefuentes.gof.singleton.SingletonEager;
import edu.alefuentes.gof.singleton.SingletonLazy;
import edu.alefuentes.gof.singleton.SingletonLazyHolder;
import edu.alefuentes.gof.strategy.*;

public class TestLabJavaPattern {

    private static MyLogger myLogger = MyLogger.getInstance();

    public static void main(String[] args) {

        // Singleton
        myLogger.showMessage(TypeLog.INFO, "START");
        myLogger.showMessage(TypeLog.INFO, "TESTING SINGLETON PATTERN");
        testingSingletonPattern();
        // Strategy
        myLogger.showMessage(TypeLog.INFO, "START");
        myLogger.showMessage(TypeLog.INFO, "TESTING STRATEGY PATTERN");
        testingStrategyPattern();
        // Facade
        myLogger.showMessage(TypeLog.INFO, "START");
        myLogger.showMessage(TypeLog.INFO, "TESTING FACADE PATTERN");
        testingFacadePattern();

    }

    private static void testingSingletonPattern() {

        SingletonLazy myLazy = SingletonLazy.getInstance();
        System.out.println(myLazy);
        myLazy = SingletonLazy.getInstance();
        System.out.println(myLazy);

        SingletonEager myEager = SingletonEager.getInstance();
        System.out.println(myEager);
        myEager = SingletonEager.getInstance();
        System.out.println(myEager);

        SingletonLazyHolder myholder = SingletonLazyHolder.getInstance();
        System.out.println(myholder);
        myholder = SingletonLazyHolder.getInstance();
        System.out.println(myholder);
    }

    private static void testingStrategyPattern() {

        Comportamental myDefault = new DefaultBehavior();
        Comportamental myActive = new ActiveBehavior();
        Comportamental mySlow = new SlowBehavior();

        HumanClon humanClon = new HumanClon();
        humanClon.setComportamental(myDefault);
        humanClon.behavior();
        humanClon.behavior();
        humanClon.setComportamental(myActive);
        humanClon.behavior();
        humanClon.behavior();
        humanClon.setComportamental(mySlow);
        humanClon.behavior();
        humanClon.behavior();
    }

    private static void testingFacadePattern() {
        int ACCOUNT_ID = 10010;

        // create subsystem objects
        Account account = new Account(ACCOUNT_ID, 3000.0);
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        CustomerSupport customerSupport = new CustomerSupport();

        // create Bank with Facade pattern with subsystem objects.
        Bank bank = new Bank(account, transactionProcessor, customerSupport);

        // use the bank interact with subsystems
        myLogger.showMessage(TypeLog.INFO, String.format("Account balance: R$%.2f", bank.checkBalance()));
        bank.deposit(500.0);
        bank.withdraw(150.0);
        bank.processTransactioon(ACCOUNT_ID, 100.0);
        bank.handleQuery("Issue with online banking");

        // end test
        myLogger.showMessage(TypeLog.INFO, String.format("Final account balance: R$%.2f", bank.checkBalance()));

    }
}
