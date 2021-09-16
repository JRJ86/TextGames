package controller;

import model.chancecards.ChanceCard;
import model.chancecards.GetMoney;
import model.chancecards.PayMoney;
import model.fields.ChanceField;
import model.fields.*;

import java.util.*;

public class SetupGame {

    public void createGame(Field[] board, Queue<ChanceCard> pile ){

        createBoard(board);
        createChancePile(pile);

//        for (int i = 0; i < 2; i++) {
//            if (i == 0){
//                createBoard(board);
//            }else {
//                createChancePile(pile);
//            }
//        }
    }

    //--------------------------------- Create board -------------------------------------------------------------------

    private void createBoard(Field[] board){

        Property property;
        ChanceField chanceField;
        FerryCompany ferryCompany;
        Brewery brewery;
        PayTax payTaxes;
        PayExtraTax payExtraTax;

        final int boardCount = 40;

        for (int i = 0; i < boardCount; i++){
            switch (i){
                case 0:
                    Start start = new Start();
                    start.setPosition(0);
                    board[i] = start;
                    break;
                case 1:
                    property = createProperty("blue", new int[]{50,100,250,750,2250,4000,6000},1000,
                            "Roedovrevej",1200,600,1);
                    board[i] = property;
                    break;
                case 2:
                    chanceField = new ChanceField();
                    chanceField.setName("Chance 1");
                    chanceField.setPosition(2);
                    board[i] = chanceField;
                    break;
                case 3:
                    property = createProperty("blue", new int[]{50,100,250,750,2250,4000,6000},1000,
                            "Hvidovrevej",1200,600, 3);
                    board[i] = property;
                    break;
                case 4:
                    payTaxes = new PayTax();
                    payTaxes.setName("Tax");
                    payTaxes.setPosition(4);
                    board[i] = payTaxes;
                    break;
                case 5:
                    ferryCompany = createShippingCompany("DFDS Seaways",
                            new int[]{500,1000,2000,4000},5);
                    board[i] = ferryCompany;
                    break;
                case 6:
                    property = createProperty("skin", new int[]{100,200,600,1800,5400,8000,11000},1000,
                            "Roskildevej",2000,1000,6);
                    board[i] = property;
                    break;
                case 7:
                    chanceField = new ChanceField();
                    chanceField.setName("Chance 2");
                    chanceField.setPosition(7);
                    board[i] = chanceField;
                    break;
                case 8:
                    property = createProperty("skin", new int[]{100,200,600,1800,5400,8000,11000},1000,
                            "Valby Langgade",2000,1000,8);
                    board[i] = property;
                    break;
                case 9:
                    property = createProperty("skin", new int[]{150,300,800,2000,6000,9000,12000},1000,
                            "Allegade",2400,1200,9);
                    board[i] = property;
                    break;
                case 10:
                    VisitJail visitJail = new VisitJail();
                    visitJail.setPosition(10);
                    board[i] = visitJail;
                    break;
                case 11:
                    property = createProperty("green", new int[]{200,400,1000,3000,9000,12500,15000},2000,
                            "Frederiksberg Alle",2800,1400,11);
                    board[i] = property;
                    break;
                case 12:
                    brewery = createBrewery("Coca Cola",12);
                    board[i] = brewery;
                    break;
                case 13:
                    property = createProperty("green",new int[]{200,400,1000,3000,9000,12500,15000},100,
                            "Bulowsvej",2800,1400,13);
                    board[i] = property;
                    break;
                case 14:
                    property = createProperty("green",new int[]{250,500,1250,3750,10000,14000,18000},2000,
                            "GL. Kongensvej",3200,1600,14);
                    board[i] = property;
                    break;
                case 15:
                    ferryCompany = createShippingCompany("DSB Rederierne KBH",
                            new int[]{500,1000,2000,4000},15);
                    board[i] = ferryCompany;
                    break;
                case 16:
                    property = createProperty("grey",new int[]{300,600,1400,4000,11000,15000,19000},2000,
                            "Bernstorffsvej",3600,1800,16);
                    board[i] = property;
                    break;
                case 17:
                    chanceField = new ChanceField();
                    chanceField.setName("Chance 3");
                    chanceField.setPosition(17);
                    board[i] = chanceField;
                    break;
                case 18:
                    property = createProperty("grey",new int[]{300,600,1400,4400,12000,16000,20000},2000,
                            "Hellerupvej",3600,1800,18);
                    board[i] = property;
                    break;
                case 19:
                    property = createProperty("grey",new int[]{350,700,1600,4400,12000,16000,20000},2000,
                            "Strandvej",4000,2000,19);
                    board[i] = property;
                    break;
                case 20:
                    Parking parking = new Parking();
                    parking.setPosition(20);
                    board[i] = parking;
                    break;
                case 21:
                    property = createProperty("red",new int[]{350,700,1800,5000,14000,17500,21000},3000,
                            "Trianglen",4400,2200,21);
                    board[i] = property;
                    break;
                case 22:
                    chanceField = new ChanceField();
                    chanceField.setName("Chance 4");
                    chanceField.setPosition(22);
                    board[i] = chanceField;
                    break;
                case 23:
                    property = createProperty("red",new int[]{350,700,1800,5000,14000,17500,21000},100,
                            "Østerbrogade",4400,2200,23);
                    board[i] = property;
                    break;
                case 24:
                    property = createProperty("red",new int[]{400,800,2000,6000,15000,18500,22000},3000,
                            "Grønningen",4800,2400,24);
                    board[i] = property;
                    break;
                case 25:
                    ferryCompany = createShippingCompany("SFL færgerne",
                            new int[]{500,1000,2000,4000},25);
                    board[i] = ferryCompany;
                    break;
                case 26:
                    property = createProperty("white",new int[]{450,900,2200,6600,16000,19500,23000},3000,
                            "Bredgade",5200,2600,26);
                    board[i] = property;
                    break;
                case 27:
                    property = createProperty("white",new int[]{450,900,2200,6600,16000,19500,23000},3000,
                            "Kgs Nytorv",5200,2600,27);
                    board[i] = property;
                    break;
                case 28:
                    brewery = createBrewery("Tuborg",28);
                    board[i] = brewery;
                    break;
                case 29:
                    property = createProperty("white",new int[]{500,1000,2400,7200,17000,20500,24000},3000,
                            "Østergade",5600,2800,29);
                    board[i] = property;
                    break;
                case 30:
                    GoToJail goToJail = new GoToJail();
                    goToJail.setPosition(30);
                    board[i] = goToJail;
                    break;
                case 31:
                    property = createProperty("yellow",new int[]{550,1100,2600,7800,18000,22000,25000},4000,
                            "Amagertorv",6000,3000,31);
                    board[i] = property;
                    break;
                case 32:
                    property = createProperty("yellow",new int[]{550,1100,2600,7800,18000,22000,25000},100,
                            "Vimmelskaftet",6000,3000,32);
                    board[i] = property;
                    break;
                case 33:
                    chanceField = new ChanceField();
                    chanceField.setName("Chance 5");
                    chanceField.setPosition(33);
                    board[i] = chanceField;
                    break;
                case 34:
                    property = createProperty("yellow",new int[]{600,1200,3000,9000,20000,24000,28000},4000,
                            "Nygade",6400,3200,34);
                    board[i] = property;
                    break;
                case 35:
                    ferryCompany = createShippingCompany("DSB Rederierne Jylland",
                            new int[]{500,1000,2000,4000},35);
                    board[i] = ferryCompany;
                    break;
                case 36:
                    chanceField = new ChanceField();
                    chanceField.setName("Chance 6");
                    chanceField.setPosition(36);
                    board[i] = chanceField;
                    break;
                case 37:
                    property = createProperty("purple",new int[]{700,1400,3500,10000,22000,26000,30000},4000,
                            "Frederiksberggade",7000,3500,37);
                    board[i] = property;
                    break;
                case 38:
                    payExtraTax = new PayExtraTax();
                    payExtraTax.setName("Extra Tax");
                    payExtraTax.setPosition(38);
                    board[i] = payExtraTax;
                    break;
                case 39:
                    property = createProperty("purple",new int[]{1000,2000,4000,12000,28000,34000,40000},4000,
                            "Rådhuspladsen",8000,4000,39);
                    board[i] = property;
                    break;
                default:
                    System.out.println("This should not happen!");
                    break;
            }
        }
    }

    /**
     * Helper method for the helper method createBoard()
     */
    private Property createProperty(String color, int[] rents, int houseCost,
                                    String name, int price, int pawnValue, int position){
        Property property = new Property(color,rents,houseCost, 0);
        property.setName(name);
        property.setPrice(price);
        property.setPawnValue(pawnValue);
        property.setOwned(false);
        property.setPosition(position);
        property.setPawned(false);
        return property;
    }
    /**
     * Helper method for the helper method createBoard()
     */
    private FerryCompany createShippingCompany(String name, int[] rents, int position){
        FerryCompany ferryCompany = new FerryCompany(rents);
        ferryCompany.setName(name);
        ferryCompany.setPrice(4000);
        ferryCompany.setPawnValue(2000);
        ferryCompany.setOwned(false);
        ferryCompany.setPosition(position);
        ferryCompany.setPawned(false);
        return ferryCompany;
    }
    /**
     * Helper method for the helper method createBoard()
     */
    private Brewery createBrewery(String name, int position){
        Brewery brewery = new Brewery();
        brewery.setName(name);
        brewery.setPrice(3000);
        brewery.setPawnValue(1500);
        brewery.setOwned(false);
        brewery.setPosition(position);
        brewery.setPawned(false);
        return brewery;
    }

    //--------------------------------- Create chance pile -------------------------------------------------------------

    private void createChancePile(Queue<ChanceCard> pile){

        PayMoney payMoney;
        GetMoney getMoney;

        final int chanceCount = 17;

        for (int i = 0; i < chanceCount; i++){
            switch (i){
                case 0:
                    payMoney = createPayMoneyChanceCard(200, "You got a parking ticket!");
                    pile.add(payMoney);
                    break;
                case 1:
                    payMoney = createPayMoneyChanceCard(3000,"Your car needs mayor repairs!");
                    pile.add(payMoney);
                    break;
                case 2:
                    payMoney = createPayMoneyChanceCard(1000, "Your car insurance is due!");
                    pile.add(payMoney);
                    break;
                case 3:
                    payMoney = createPayMoneyChanceCard(1500,"Your car needs minor repairs!");
                    pile.add(payMoney);
                    break;
                case 4:
                    payMoney = createPayMoneyChanceCard(1000,"You ran a stop sign!");
                    pile.add(payMoney);
                    break;
                case 5:
                    payMoney = createPayMoneyChanceCard(200,"You need to pay cigarette customs!");
                    pile.add(payMoney);
                    break;
                case 6:
                    payMoney = createPayMoneyChanceCard(2000,"You have to go to the dentist for a full checkup!");
                    pile.add(payMoney);
                    break;
                case 7:
                    getMoney = createGetMoneyChanceCard(3000,"The local authority owes you some money!");
                    pile.add(getMoney);
                    break;
                case 8:
                    getMoney = createGetMoneyChanceCard(1000,"Your premium bond is out!");
                    pile.add(getMoney);
                    break;
                case 9:
                    getMoney = createGetMoneyChanceCard(1000,"Betting on horses payed out!");
                    pile.add(getMoney);
                    break;
                case 10:
                    getMoney = createGetMoneyChanceCard(1000,"Receive dividends on your premium shares!");
                    pile.add(getMoney);
                    break;
                case 11:
                    getMoney = createGetMoneyChanceCard(800,"Receive dividends on your secondary shares!");
                    pile.add(getMoney);
                    break;
                case 12:
                    getMoney = createGetMoneyChanceCard(2000,"Receive dividends on all your shares!");
                    pile.add(getMoney);
                    break;
                case 13:
                    getMoney = createGetMoneyChanceCard(200,"You sell some personally grown produce!");
                    pile.add(getMoney);
                    break;
                case 14:
                    getMoney = createGetMoneyChanceCard(1000,"You have received a salary increase!");
                    pile.add(getMoney);
                    break;
                case 15:
                    getMoney = createGetMoneyChanceCard(1000,"You finally sold your old car!");
                    pile.add(getMoney);
                    break;
                case 16:
                    getMoney = createGetMoneyChanceCard(500,"You have won the lottery!");
                    pile.add(getMoney);
                    break;
                default:
                    System.out.println("Switch in default");
                    break;
            }
        }

        Collections.shuffle((List<?>) pile, new Random());
    }

    /**
     *  Helper method for createChancePile()
     */
    private PayMoney createPayMoneyChanceCard(int amount, String description){
        PayMoney payMoney = new PayMoney(amount);
        payMoney.setDescription(description);
        return payMoney;
    }
    /**
     *  Helper method for createChancePile()
     */
    private GetMoney createGetMoneyChanceCard(int amount, String description){
        GetMoney getMoney = new GetMoney(amount);
        getMoney.setDescription(description);
        return getMoney;
    }

    //-------------------- Print chance pile and board methods ---------------------------------------------------------

    public void printChancePile(Queue<ChanceCard> pile){
        for (ChanceCard item: pile) {
            System.out.println(item);
        }
    }

    public void printBoard(Field[] board){
        for (Field item: board) {
            System.out.println(item);
        }
    }
}
