package model.fields;

public class Property extends BuyableField {

    private String color;
    private int[] rents;
    private int houseCost;
    private int houses;

    public Property(String color, int[] rents, int houseCost, int houses) {
        this.color = color;
        this.rents = rents;
        this.houseCost = houseCost;
        this.houses = houses;
    }

    /**
     * Helper for toString()
     * @return String saying if a property is owned
     */
    private String isPropertyOwned(){
        if (!isOwned()){
            return "not owned";
        }else
            return "owned";
    }

    /**
     * Helper for toString()
     * @return String saying if a property has a hotel
     */
    private String buildingsOnProperty(Property property){
        switch (houses){
            case 0:
                return property.getName() + " has 0 houses!";
            case 1:
                return property.getName() + " has 1 house!";
            case 2:
                return property.getName() + " has 2 houses!";
            case 3:
                return property.getName() + " has 3 houses!";
            case 4:
                return property.getName() + " has 4 houses!";
            case 5:
                return property.getName() + " has 1 hotel!";
            default:
                return "This should not happen!!!";
        }
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "               Property: " + getName() + ", and is " + color + " color\n\n" +
                "               The price is: " + getPrice() + " kr \n\n" +
                "               Rent:               " + rents[0] + " kr\n" +
                "               Rent with 1 house:  " + rents[1] + " kr\n" +
                "               Rent with 2 houses: " + rents[2] + " kr\n" +
                "               Rent with 3 houses: " + rents[3] + " kr\n" +
                "               Rent with 4 houses: " + rents[4] + " kr\n" +
                "               Rent with 1 hotel:  " + rents[5] + " kr\n\n" +
                "               1 house costs " + houseCost + " kr\n" +
                "               1 hotel costs " + houseCost + " kr, if the property has 4 houses \n\n" +
                "               The property has " + buildingsOnProperty(this) + "\n" +
                "               The property is " + isPropertyOwned() + " by a player! \n" +
                "               The property can be pawned for " + getPawnValue() + " kr\n" +
                "               The property is owned by: " + getOwner() + "\n" +
                "-------------------------------------------------------------------------------- \n";
    }

    //--------------------- Getters & Setters --------------------------------------------------------------------------

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int[] getRents() {
        return rents;
    }

    public void setRents(int[] rents) {
        this.rents = rents;
    }

    public int getHouseCost() {
        return houseCost;
    }

    public void setHouseCost(int houseCost) {
        this.houseCost = houseCost;
    }

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }

}
