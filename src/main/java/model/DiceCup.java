package model;

public class DiceCup {

    private final Dice dice1;
    private final Dice dice2;

    public DiceCup() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    public void rollCup(){
        dice1.roll();
        dice2.roll();
    }

    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    @Override
    public String toString() {
        return "dice 1 rolled: " + dice1.getValue()+
                "\n" +
                "dice 2 rolled: " + dice2.getValue()+
                "\n" +
                "Your total is: " + (dice1.getValue() + dice2.getValue());
    }
}
