package edu.alefuentes.gof.facade.subsystembank;

public class CustomerSupport {

    /**
     * Method to log one query
     * @param query
     */
    public void logQuery(String query){
        System.out.println(String.format("[CUSTOMSUPPORT-INFO] - logged customer query %s", query));
    }

    /**
     * Method to resolve one query
     * @param query
     */
    public void resolveQuery(String query){
        System.out.println(String.format("[CUSTOMSUPPORT-INFO] - resolved customer query %s", query));
    }

}
