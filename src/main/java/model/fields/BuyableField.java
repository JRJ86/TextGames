package model.fields;

public abstract class BuyableField extends Field {

    private int price;
    private int pawnValue;
    private boolean owned;

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
}
