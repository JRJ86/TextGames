package model.fields;

import model.Player;

public abstract class BuyableField extends Field {

    private int price;
    private int pawnValue;
    private boolean owned;
    private Player owner;
    private boolean pawned;

    //---------------------- Getters & Setters -------------------------------------------------------------------------

    public int getPawnValue() {
        return pawnValue;
    }

    public void setPawnValue(int pawnValue) {
        this.pawnValue = pawnValue;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isPawned() {
        return pawned;
    }

    public void setPawned(boolean pawned) {
        this.pawned = pawned;
    }
}
