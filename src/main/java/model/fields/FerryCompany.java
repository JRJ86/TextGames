package model.fields;

public class FerryCompany extends BuyableField {

    private int[] rents;

    public FerryCompany(int[] rents) {
        this.rents = rents;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "               Ferry Company: " + getName() + " \n\n" +
                "               The price is: " + getPrice() + " kr\n\n" +
                "               Own 1 Ferry Company and rent is:   " + rents[0] + " kr\n" +
                "               Own 2 Ferry Companies and rent is: " + rents[1] + " kr\n" +
                "               Own 3 Ferry Companies and rent is: " + rents[2] + " kr\n" +
                "               Own 4 Ferry Companies and rent is: " + rents[3] + " kr\n\n" +
                "               You can pawn it for: " + getPawnValue() + " kr\n" +
                "               The Ferry company is owned by: " + getOwner().getName() + "\n" +
                "-------------------------------------------------------------------------------- \n";
    }

    //------------------ Getters & Setters -----------------------------------------------------------------------------

    public int[] getRents() {
        return rents;
    }

    public void setRents(int[] rents) {
        this.rents = rents;
    }
}
