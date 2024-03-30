package edu.alefuentes.gof.strategy;

public class HumanClon {

    private Comportamental comportamental;

    public void setComportamental(Comportamental comportamental) {
        this.comportamental = comportamental;
    }

    public void behavior(){
        this.comportamental.move();
    }
}
