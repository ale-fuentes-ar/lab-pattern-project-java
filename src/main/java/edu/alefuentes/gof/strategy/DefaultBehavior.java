package edu.alefuentes.gof.strategy;

public class DefaultBehavior implements Comportamental {

    @Override
    public void move() {
        System.out.println("A default behavior ... ");
    }
}
