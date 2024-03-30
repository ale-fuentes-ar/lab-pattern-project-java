package edu.alefuentes.gof.strategy;

public class SlowBehavior implements Comportamental{
    @Override
    public void move() {
        System.out.println("A slow behavior ... ");
    }
}
