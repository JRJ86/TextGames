package model;

import model.fields.BuyableField;

import java.util.ArrayList;

public class Player {

    private String name;
    private int walletAmount;
    private int position;
    private int currentRoll;
    private ArrayList<BuyableField> properties = new ArrayList<>(); // Maybe not initialize! TODO
    private boolean inJail;
    private DiceCup diceCup = new DiceCup();

    public Player(String name, int walletAmount, int position, boolean inJail) {
        this.name = name;
        this.walletAmount = walletAmount;
        this.position = position;
        this.inJail = inJail;
    }

    public Player() {
    }

    public void chooceDice(int sides){
        diceCup.getDice1().setSides(sides);
        diceCup.getDice2().setSides(sides);
    }

    public void throwDice(){
        diceCup.rollCup();
        currentRoll = diceCup.getDice1().getValue() + diceCup.getDice2().getValue();
    }

    /**
     * @return The individual dice values and the total current roll
     */
    public String yourRoll(){
        return this.name + " rolled: " + diceCup.getDice1().getValue() +
                " and " + diceCup.getDice2().getValue()
                + "\n" +
                "Total roll: " + currentRoll;
    }

    /**
     * TODO
     * @return
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wallet=" + walletAmount +
                ", position=" + position +
                ", currentRoll=" + currentRoll +
                ", inJail=" + inJail +
                '}';
    }

    //--------------------------------- Getters & Setters --------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(int walletAmount) {
        this.walletAmount = walletAmount;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(int currentRoll) {
        this.currentRoll = currentRoll;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public DiceCup getDiceCup() {
        return diceCup;
    }

    public void setDiceCup(DiceCup diceCup) {
        this.diceCup = diceCup;
    }

    public ArrayList<BuyableField> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<BuyableField> properties) {
        this.properties = properties;
    }
}
