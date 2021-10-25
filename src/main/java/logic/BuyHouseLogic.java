package logic;

import model.Player;
import model.fields.BuyableField;
import model.fields.Property;

import java.util.*;

public class BuyHouseLogic {

    public void buyHouse(Player owner, Scanner scanner){

        boolean found = false;
        boolean noMore = false;
        String colorChoice;
        int houseChoice = 0;
        int houseTotal = 0;
        String quit;

        // list of group colors to buy on
        ArrayList<String> ownedPropertyGroups = new ArrayList<>();

        // list of properties in the property group you want to buy on
        ArrayList<Property> chosenPropertyGroup = new ArrayList<>();

        // hashmap to see which property groups is available
        HashMap<String,Integer> ownedColors = new HashMap<String,Integer>(){{
            put("blue", 0);
            put("skin", 0);
            put("green", 0);
            put("grey", 0);
            put("red",0);
            put("white",0);
            put("yellow",0);
            put("purple",0);
        }};
        Iterator<Map.Entry<String, Integer>> ownedColorsIterator = ownedColors.entrySet().iterator();

        // check which Property groups is owned by player
        for (BuyableField field: owner.getProperties()) {
            if (field instanceof Property){
                switch (((Property) field).getColor()){
                    case "blue":
                        ownedColors.put("blue",ownedColors.get("blue") + 1);
                        break;
                    case "skin":
                        ownedColors.put("skin",ownedColors.get("skin") + 1);
                        break;
                    case "green":
                        ownedColors.put("green",ownedColors.get("green") + 1);
                        break;
                    case "grey":
                        ownedColors.put("grey",ownedColors.get("grey") + 1);
                        break;
                    case "red":
                        ownedColors.put("red",ownedColors.get("red") + 1);
                        break;
                    case "white":
                        ownedColors.put("white",ownedColors.get("white") + 1);
                        break;
                    case "yellow":
                        ownedColors.put("yellow",ownedColors.get("yellow") + 1);
                        break;
                    case "purple":
                        ownedColors.put("purple",ownedColors.get("purple") + 1);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid color: " + ((Property) field).getColor());
                }
            }
        }

        while (true){
            System.out.println(owner.getName() + " wants to buy some houses. The available property groups to buy at is:\n ");

            while (ownedColorsIterator.hasNext()){
                Map.Entry<String, Integer> mapElement = ownedColorsIterator.next();
                if ((mapElement.getValue().equals(3) &&
                        !(mapElement.getKey().equals("blue") ||
                                mapElement.getKey().equals("purple"))) ||
                        mapElement.getValue().equals(2) && (mapElement.getKey().equals("blue") || mapElement.getKey().equals("purple"))){
                    System.out.println("The property group of color " + mapElement.getKey() + " is eligible to buy houses on!");
                    ownedPropertyGroups.add(mapElement.getKey());
                }
            }

            if (ownedPropertyGroups.isEmpty()){
                System.out.println(owner.getName() + " does not have any valid properties to buy on!\n");
                break;
            }

            System.out.println();
            System.out.println("Choose which color to buy on:");

            do {
                colorChoice = scanner.next();

                for (String color: ownedPropertyGroups) {
                    if (color.equals(colorChoice)){
                        found = true;
                        break;
                    }
                }

                if (!found){
                    System.out.println("You dont own all properties of " + colorChoice + " color. Choose another!\n");
                }

            } while (!found);

            // adding the Properties in the chosen color to the chosenPropertyGroup ArrayList
            // Counting how many houses the property group have combined ( houseTotal )
            for (BuyableField field: owner.getProperties()) {
                if (field instanceof Property && ((Property) field).getColor().equals(colorChoice)) {
                    chosenPropertyGroup.add((Property) field);
                    //chosenPropertyGroup.put(field.getName(),((Property) field).getHouses());
                    houseTotal = houseTotal + ((Property) field).getHouses();
                }
            }

            // how many houses can be bought?
            // if houseTotal is above the max number of 2 or 3 fielded property groups then another group must be chosen
            if (colorChoice.equals("blue") || colorChoice.equals("purple")){
                if (houseTotal >= 10){
                    System.out.println(owner.getName() + " cannot have anymore houses or hotels on the " + colorChoice + " property group!");
                    System.out.println("Press 'quit' to stop buying houses, or press any key to select another property group!");

                    quit = scanner.next();
                    if (quit.equals("quit")){
                        System.out.println("Going back to the previous menu!");
                        break;
                    }

                }else {
                    int maxPurchase = (10 - houseTotal);
                    houseChoice = getHouseChoice(scanner, colorChoice, houseChoice, maxPurchase);
                    placeHouses(houseChoice, chosenPropertyGroup,owner);
                    noMore = true;
                }

            }else {
                if (houseTotal >= 15){
                    System.out.println(owner.getName() + " cannot have anymore houses or hotels on the " + colorChoice + " property group!");
                    System.out.println("Press 'quit' to stop buying houses, or press any key to select another property group!");

                    quit = scanner.next();
                    if (quit.equals("quit")){
                        System.out.println("Going back to the previous menu!");
                        break;
                    }

                }else {
                    int maxPurchase = (15 - houseTotal);
                    houseChoice = getHouseChoice(scanner, colorChoice, houseChoice, maxPurchase);
                    placeHouses(houseChoice, chosenPropertyGroup,owner);
                    noMore = true;
                }
            }

            // If this list is not emptied out, then if you choose a new property group to buy on, then the old property group will still be part of group
            chosenPropertyGroup.clear();
            ownedPropertyGroups.clear();

            if (noMore){
                break;
            }
        }
    }

    /**
     * Helper for buyHouse() to avoid duplicate code
     *
     * @param colorChoice The property group color
     * @param houseChoice The amount of houses you want to buy
     * @param maxPurchase The max amount of houses available to purchase
     * @return The amount of houses to buy
     */
    private int getHouseChoice(Scanner scanner, String colorChoice, int houseChoice, int maxPurchase) {
        System.out.println("You are able to buy " + maxPurchase + " houses on the " + colorChoice + " property group!");

        do {
            System.out.println("How many houses do you want to buy? It has to be less than " + maxPurchase);
            try {
                houseChoice = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("You have to input a number! Try again.");
            }

            if (houseChoice > maxPurchase){
                System.out.println("You can buy more than " + houseChoice + "!");
            }else if (houseChoice <= 0){
                System.out.println("You cant buy '0' or a negative amount of buildings!");
            }else {
                break;
            }

        }while (true);

        return houseChoice;
    }

    /**
     *
     *
     * @param houseChoice
     * @param chosenPropertyGroup
     * @param owner
     */
    private void placeHouses(int houseChoice, ArrayList<Property> chosenPropertyGroup, Player owner){

        boolean done = false;
        int houseNumber = houseChoice;
        Property property = chosenPropertyGroup.get(0);

        if(owner.getWalletAmount() < (property.getHouseCost() * houseChoice)){
            System.out.println("You do not have enough funds for the purchase.\n" +
                    "You have: " + owner.getWalletAmount() + " kr and you need: " + (property.getHouseCost() * houseChoice));
        }else {
            do {

                for (Property value : chosenPropertyGroup) {
                    if (houseNumber <= 0) {
                        done = true;
                        break;
                    }
                    if (value.getHouses() < 5) {
                        value.setHouses(value.getHouses() + 1);
                    } else {
                        System.out.println(value.getName() + " now has a hotel, and cannot be upgraded more!\n");
                    }

                    houseNumber = houseNumber - 1;
                }

            } while(!done);

            owner.setWalletAmount(owner.getWalletAmount() - (property.getHouseCost() * houseChoice));
        }

    }

    //TODO ERASE
    private ArrayList<Integer> splitValues(int houseChoice, int splitAmount){

        int amount1;
        int amount2;
        ArrayList<Integer> splitValues = new ArrayList<>();
        int[] temp = new int[splitAmount];

        if (houseChoice % splitAmount == 0){
            Arrays.fill(temp, (houseChoice / splitAmount));

        }else {
            amount2 = splitAmount - (houseChoice %  splitAmount);
            amount1 = houseChoice / splitAmount;

            for (int i = 0; i < temp.length; i++) {
                if (i >= amount2){
                    temp[i] = (amount1 + 1);

                }else {
                    temp[i] = amount1;
                }
            }
        }

        for (Integer number: temp) {
            splitValues.add(number);
        }

        Arrays.fill(temp, 0);

        return splitValues;
    }

}
