package edu.alefuentes.gof.singleton;


public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return  instance;
    }

    @Override
    public String toString() {
        return String.format("SingletonLazy -> address memory %s", Integer.toHexString(System.identityHashCode(this)));
    }
}
