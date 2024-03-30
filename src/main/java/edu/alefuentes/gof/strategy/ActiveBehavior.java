package edu.alefuentes.gof.strategy;

public class ActiveBehavior implements Comportamental{

    @Override
    public void move() {
        System.out.println("A active behavior ... ");
    }
}
