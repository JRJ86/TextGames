package logic;

import model.Board;
import model.Player;
import model.fields.Brewery;
import model.fields.BuyableField;
import model.fields.Property;
import model.fields.ShippingCompany;

public class PayRentLogic {

    // ------------------------------------------ Property rent --------------------------------------------------------

    /**
     * This function gives a player the proper rent when another player lands on the property
     *
     * @param p1 The player who needs to pay rent
     * @param p2 The player receiving the rent
     * @param property The property owned by p2 and landed on by p1
     */
    public void payPropertyRent(Player p1, Player p2, Property property){

        if (property.getHouses() == 0){
            int counter = 1;
            String color = property.getColor();

            //check the property's owner for more properties of same color
            for (BuyableField item: p2.getProperties()) {
                if (item instanceof Property && ((Property) item).getColor().equals(color) && item != property){
                    counter++;
                }
            }

            //if the owner got all 3 property's of same color he needs to pay double normal rent
            //if the property's color is blue or purple, there will only be 2 properties with the same color
            if (color.equals("purple") || color.equals("blue")){
                switch (counter){
                    case 1:
                        int amount1 = property.getRents()[0];
                        p1.setWalletAmount(p1.getWalletAmount() - amount1);
                        p2.setWalletAmount(p2.getWalletAmount() + amount1);
                        break;
                    case 2:
                        int amount2 = property.getRents()[1];
                        p1.setWalletAmount(p1.getWalletAmount() - amount2);
                        p2.setWalletAmount(p2.getWalletAmount() + amount2);
                        break;

                }
            }else {
                switch (counter){
                    case 1:
                    case 2:
                        int amount1 = property.getRents()[0];
                        p1.setWalletAmount(p1.getWalletAmount() - amount1);
                        p2.setWalletAmount(p2.getWalletAmount() + amount1);
                        break;
                    case 3:
                        int amount3 = property.getRents()[1];
                        p1.setWalletAmount(p1.getWalletAmount() - amount3);
                        p2.setWalletAmount(p2.getWalletAmount() + amount3);
                        break;
                }
            }
        }else {
            switch (property.getHouses()){
                case 1:
                    int oneHouse = property.getRents()[2];
                    p1.setWalletAmount(p1.getWalletAmount() - oneHouse);
                    p2.setWalletAmount(p2.getWalletAmount() + oneHouse);
                    break;
                case 2:
                    int twoHouses = property.getRents()[3];
                    p1.setWalletAmount(p1.getWalletAmount() - twoHouses);
                    p2.setWalletAmount(p2.getWalletAmount() + twoHouses);
                    break;
                case 3:
                    int threeHouses = property.getRents()[4];
                    p1.setWalletAmount(p1.getWalletAmount() - threeHouses);
                    p2.setWalletAmount(p2.getWalletAmount() + threeHouses);
                    break;
                case 4:
                    int fourHouses = property.getRents()[5];
                    p1.setWalletAmount(p1.getWalletAmount() - fourHouses);
                    p2.setWalletAmount(p2.getWalletAmount() + fourHouses);
                    break;
                case 5:
                    int hotel = property.getRents()[6];
                    p1.setWalletAmount(p1.getWalletAmount() - hotel);
                    p2.setWalletAmount(p2.getWalletAmount() + hotel);
                    break;
                default:
                    System.err.println(System.out);
            }
        }

    }

    /**
     * When this function is called it will return the rent of a players property
     *
     * @param property the property, which rent we need to see
     * @param player the player who owns it
     * @return the rent
     */
    public int showPropertyRent(Property property, Player player) {

        String color = property.getColor();
        int propertyAmount = 0;

        for (BuyableField field : player.getProperties()) {
            if (field instanceof Property) {
                if (((Property) field).getColor().equals(color)) {
                    propertyAmount++;
                }
            }
        }
        if (color.equals("blue") || color.equals("purple")) {
            if (property.getHouses() == 0) {
                switch (propertyAmount) {
                    case 1:
                        return property.getRents()[0];
                    case 2:
                        return property.getRents()[1];
                    default:
                        System.err.println("Error when calling propertyRent()!");
                }
            } else {
                return propertyRentSwitch(property);
            }
        } else {
            if (property.getHouses() == 0) {
                switch (propertyAmount) {
                    case 1:
                    case 2:
                        return property.getRents()[0];
                    case 3:
                        return property.getRents()[1];
                    default:
                        System.err.println("Error when calling propertyRent()!");
                }
            } else {
                return propertyRentSwitch(property);
            }
        }
        return propertyAmount;
    }

    /**
     * Helper function for showPropertyRent()
     *
     */
    private static int propertyRentSwitch(Property property){
        switch (property.getHouses()) {
            case 1:
                return property.getRents()[2];
            case 2:
                return property.getRents()[3];
            case 3:
                return property.getRents()[4];
            case 4:
                return property.getRents()[5];
            case 5:
                return property.getRents()[6];
            default:
                System.err.println("Error when calling propertyRent()!");
        }
        return 0;
    }

    // ---------------------------- Shipping Company rent --------------------------------------------------------------

    /**
     *
     * @param p1 The player who needs to pay rent
     * @param p2 The player receiving the rent
     */
    public void payShippingCompanyRent(Player p1, Player p2, ShippingCompany shippingCompany){

        int counter = 1;

        for (BuyableField field: p2.getProperties()) {
            if (field instanceof ShippingCompany && field != shippingCompany){
                counter++;
            }
        }

        switch (counter){
            case 1:
                int amount1 = shippingCompany.getRents()[0];
                p1.setWalletAmount(p1.getWalletAmount() - amount1);
                p2.setWalletAmount(p2.getWalletAmount() + amount1);
                break;
            case 2:
                int amount2 = shippingCompany.getRents()[1];
                p1.setWalletAmount(p1.getWalletAmount() - amount2);
                p2.setWalletAmount(p2.getWalletAmount() + amount2);
                break;
            case 3:
                int amount3 = shippingCompany.getRents()[2];
                p1.setWalletAmount(p1.getWalletAmount() - amount3);
                p2.setWalletAmount(p2.getWalletAmount() + amount3);
                break;
            case 4:
                int amount4 = shippingCompany.getRents()[3];
                p1.setWalletAmount(p1.getWalletAmount() - amount4);
                p2.setWalletAmount(p2.getWalletAmount() + amount4);
                break;
            default:
                System.err.println("The counter in the Switch in payShippingCompanyRent() has an error value!");
        }

    }

    // -------------------------------- Brewery rent -------------------------------------------------------------------

    /**
     *
     * @param p1 The player who needs to pay rent
     * @param p2 The player receiving the rent
     */
    public void payBreweryRent(Player p1, Player p2, Brewery brewery){

    }
}
