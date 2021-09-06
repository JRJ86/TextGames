package logic;

import model.Player;
import model.fields.Brewery;
import model.fields.BuyableField;
import model.fields.FerryCompany;
import model.fields.Property;

public class PayRentLogic {

    // ------------------------------------------ Property rent --------------------------------------------------------

    /**
     * This function gives a player the proper rent when another player lands on the property
     *
     * IMPORTANT!! This function does NOT see if the player has enough money to pay the rent
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

    // ---------------------------- Ferry Company rent --------------------------------------------------------------

    /**
     * This function handles the rent paying when a player lands on another players Ferry Company
     *
     * IMPORTANT!! This function does NOT see if the player has enough money to pay the rent
     *
     * @param visitor The player who needs to pay rent
     * @param owner The player receiving the rent
     */
    public void payFerryCompanyRent(Player visitor, Player owner, FerryCompany ferryCompany){

        int counter = 1;

        if (visitor.getPosition() == ferryCompany.getPosition()){
            for (BuyableField field: owner.getProperties()) {
                if (field instanceof FerryCompany && field != ferryCompany){
                    counter++;
                }
            }

            switch (counter){
                case 1:
                    int amount1 = ferryCompany.getRents()[0];
                    visitor.setWalletAmount(visitor.getWalletAmount() - amount1);
                    owner.setWalletAmount(owner.getWalletAmount() + amount1);
                    break;
                case 2:
                    int amount2 = ferryCompany.getRents()[1];
                    visitor.setWalletAmount(visitor.getWalletAmount() - amount2);
                    owner.setWalletAmount(owner.getWalletAmount() + amount2);
                    break;
                case 3:
                    int amount3 = ferryCompany.getRents()[2];
                    visitor.setWalletAmount(visitor.getWalletAmount() - amount3);
                    owner.setWalletAmount(owner.getWalletAmount() + amount3);
                    break;
                case 4:
                    int amount4 = ferryCompany.getRents()[3];
                    visitor.setWalletAmount(visitor.getWalletAmount() - amount4);
                    owner.setWalletAmount(owner.getWalletAmount() + amount4);
                    break;
                default:
                    System.err.println("The counter in the Switch in payShippingCompanyRent() has an error value!");
            }
        }else {
            System.err.println(owner.getName() + " is not standing on the field: " + ferryCompany.getName() +
                    ". An error has occurred!!!");
        }
    }

    /**
     * This function will display the rent of a certain ferry company
     *
     * @param owner The owner of the FerryCompany
     * @param ferryCompany One of the FerryCompanies
     * @return The rent calculated from the owner's property list
     */
    public int showFerryCompanyRent(Player owner, FerryCompany ferryCompany){

        int count = 0;

        for (BuyableField field: owner.getProperties()) {
            if (field instanceof FerryCompany){
                count++;
            }
        }

        switch (count){
            case 0:
                return 0;
            case 1:
                return ferryCompany.getRents()[0];
            case 2:
                return ferryCompany.getRents()[1];
            case 3:
                return ferryCompany.getRents()[2];
            case 4:
                return ferryCompany.getRents()[3];
            default:
                System.out.println("This is NOT supposed to happen!! logic.PayRentLogic.showFerryCompanyRent");
                return -1;
        }

    }

    // -------------------------------- Brewery rent -------------------------------------------------------------------

    /**
     *
     * Function for paying rent to a Brewery owner on the basis of the paying players
     * current roll and the Brewery owners amount of Breweries
     *
     * IMPORTANT!! This function does NOT see if the player has enough money to pay the rent
     *
     * @param visitor The player who needs to pay rent
     * @param owner The player receiving the rent
     * @param brewery The Brewery that visitor has landed on
     */
    public void payBreweryRent(Player visitor, Player owner, Brewery brewery){

        int count = 1;

        for (BuyableField field: owner.getProperties()) {
            if (field instanceof Brewery && field != brewery){
                count++;
            }
        }

        switch (count){
            case 1:
                int amount1 = visitor.getCurrentRoll() * 100;
                visitor.setWalletAmount(visitor.getWalletAmount() - amount1);
                owner.setWalletAmount(owner.getWalletAmount() + amount1);
                break;
            case 2:
                int amount2 = visitor.getCurrentRoll() * 200;
                visitor.setWalletAmount(visitor.getWalletAmount() - amount2);
                owner.setWalletAmount(owner.getWalletAmount() + amount2);
                break;
            default:
                System.err.println("This should not happen!!!!");
                break;
        }
    }

    /**
     * This function returns an Integer value representing what player2 needs to pay
     * to player1 when seeing how many Breweries player1 has and what player2's current roll is
     *
     * @param player1 The player who got the properties
     * @param player2 The player rolling the dice
     */
    public int showBreweryRent(Player player1, Player player2){

        int count = 0;

        for (BuyableField field: player1.getProperties()) {
            if (field instanceof Brewery){
                count++;
            }
        }

        switch (count){
            case 0:
                return 0;
            case 1:
                return player2.getCurrentRoll() * 100;
            case 2:
                return player2.getCurrentRoll() * 200;
            default:
                System.err.println("Error in showBreweryRent() function!!!");
        }

        return -1;
    }
}
