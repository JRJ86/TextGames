package model.fields;

public class FerryCompany extends BuyableField {

    private int[] rents;

    public FerryCompany(int[] rents) {
        this.rents = rents;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "               Shipping Company: " + getName() + " \n\n" +
                "               The price is: " + getPrice() + " kr\n\n" +
                "               Own 1 Shipping Company and rent is:   " + rents[0] + " kr\n" +
                "               Own 2 Shipping Companies and rent is: " + rents[1] + " kr\n" +
                "               Own 2 Shipping Companies and rent is: " + rents[2] + " kr\n" +
                "               Own 2 Shipping Companies and rent is: " + rents[3] + " kr\n\n" +
                "               You can pawn it for: " + getPawnValue() + " kr\n" +
                "               The Shipping company is owned by: " + getOwner() + "\n" +
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
