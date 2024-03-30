package edu.alefuentes.gof.facade.subsystembank;

public class TransactionProcessor {

    /**
     * Method to process a transaction
     * @param accountId
     * @param amount
     */
    public void proccessTransaction(int accountId, double amount){
        System.out.println(String.format("[TRANSACTIONPROCESSOR-INFO] - processed transation for account %d: R$%.2f", accountId, amount));
    }


}
