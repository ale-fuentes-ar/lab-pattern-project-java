package edu.alefuentes.gof.singleton;

/**
 * @see <a href="https://stackoverflow.com/a/24018148">reference</a>
 */
public class SingletonLazyHolder {

    private static class InstanceHolder {
        public static SingletonLazyHolder instance = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstance(){
        return InstanceHolder.instance;
    }

    @Override
    public String toString() {
        return String.format("SingletonLazyHolder -> address memory %s", Integer.toHexString(System.identityHashCode(this)));
    }
}
