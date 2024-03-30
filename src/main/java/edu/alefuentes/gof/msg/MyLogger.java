package edu.alefuentes.gof.msg;

public class MyLogger {

    public static MyLogger instance = new MyLogger();
    private MyLogger() { super(); }

    public static MyLogger getInstance(){
        return instance;
    }

    private final String INFO_MSG = "[INFO]";
    private final String WARNING_MSG = "[WARNING]";
    private final String ERRO_MSG = "[ERRO]";

    public void showMessage(TypeLog typeLog, String message){
        switch (typeLog){
            case INFO : setMessage(INFO_MSG, message); break;
            case WARNING : setMessage(WARNING_MSG, message); break;
            case ERROR : setMessage(ERRO_MSG, message); break;
        }
    }

    private void setMessage(String typeMsg, String message) {
        System.out.println(String.format("%s - %s", typeMsg, message));
    }

}
