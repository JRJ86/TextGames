package model;

import java.util.Random;

public class Dice {

    private int sides;
    private int value;
    Random random = new Random();

    public Dice() {
    }

    public void roll(){
        value = random.nextInt(sides)+1;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "This dice has " + sides + " sides, and a current eye value of " + value + "!";
    }
}
