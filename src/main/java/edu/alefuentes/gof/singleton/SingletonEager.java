package edu.alefuentes.gof.singleton;

public class SingletonEager {

    public static SingletonEager instance = new SingletonEager();

    private SingletonEager(){
        super();
    }

    public static SingletonEager getInstance(){
        return instance;
    }

    @Override
    public String toString() {
        return String.format("SingletonEager -> address memory %s", Integer.toHexString(System.identityHashCode(this)));
    }

}
