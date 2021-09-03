package Testing;

import logic.BuyFieldLogic;
import logic.JailLogik;
import controller.SetupGame;
import logic.PayRentLogic;
import logic.PayTaxLogic;
import model.Board;
import model.Player;
import model.fields.*;
import view.TUI;

import java.util.Random;
import java.util.Scanner;

public class NonUnittestTesting {

    public static void test() throws InterruptedException {

        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        SetupGame setupGame = new SetupGame();
        JailLogik jailLogik = new JailLogik();
        PayTaxLogic payTaxLogic = new PayTaxLogic();
        PayRentLogic payRentLogic = new PayRentLogic();
        BuyFieldLogic buyFieldLogic = new BuyFieldLogic();

        while (true){

            System.out.println("Which test do you want to run? \n\n" +
                    "1: Test property methods and functions\n" +
                    "2: Test dice rolling methods and functions\n" +
                    "3: Print the chance pile\n" +
                    "4: Print the board\n" +
                    "5: Test JailLogic methods\n" +
                    "6: Test TUI menu's\n" +
                    "7: Test pay rent Brewery\n" +
                    "8: Test PayTaxLogic methods\n" +
                    "9: Test pay rent Property\n" +
                    "10: Test pay rent FerryCompany\n");

            int choice = scanner.nextInt();
            while (true){
                switch (choice){
                    case 1:
                        testProperty(player);
                        break;
                    case 2:
                        testDiceRolling(scanner,player);
                        break;
                    case 3:
                        testPrintChancePile(board,setupGame);
                        break;
                    case 4:
                        testPrintBoard(setupGame,board);
                        break;
                    case 5:
                        testGetOutOfJail(board,setupGame,jailLogik,scanner);
                        break;
                    case 6:
                        testTUI(scanner,board,setupGame);
                        break;
                    case 7:
                        testPayRentBrewery(board,setupGame,payRentLogic,buyFieldLogic);
                        break;
                    case 8:
                        testPayTaxLogic(board,setupGame,payTaxLogic,scanner);
                        break;
                    case 9:
                        testPayRentProperty(setupGame,board,payRentLogic);
                        break;
                    case 10:

                    default:
                        System.out.println("Not a valid test number!!");
                        break;

                }
                System.out.println("If you want to run a different test press 'new'!");
                System.out.println("If you want to quit press 'exit'! \n");
                System.out.println("To run test again press random key! \n");
                String choice2 = scanner.next();

                if (choice2.equals("new")){
                    break;
                }else if (choice2.equals("exit")){
                    System.out.println("Exiting!!");
                    System.exit(0);
                }else {
                    System.out.println("Running test again!");
                }
            }
        }
    }

    private static void testGetOutOfJail(Board board, SetupGame setupGame, JailLogik jailLogik, Scanner scanner) {

        System.out.println("Creating the board");
        setupGame.createGame(board.getBoard(), board.getChancePile());
        System.out.println("Board created");
        System.out.println("Creating player!");
        Player player = new Player("Jacob", 4000, 0, false);
        System.out.println("Player: \n" + player);
        System.out.println();
        System.out.println("Putting player on the getting caught by police field!\n" +
                "It is the field:\n "+ board.getBoard()[30].toString());
        player.setPosition(30);
        System.out.println("Player position is now: " + player.getPosition());
        jailLogik.goToJail(player);
        System.out.println();
        System.out.println(player.getName() + " is in jail because: \n" +
                "Is in jail: " + player.isInJail() + "\n" +
                "Player position is now: " + player.getPosition());
        System.out.println();
        System.out.println("To get out of jail, roll equal dice");
        player.chooceDice(6);

        boolean check;

        do {
            check = jailLogik.getOutOfJail(scanner,player);
        }while (!check);

    }

    /**
     * Testing the creation of the board by creating it and printing it
     */
    private static void testPrintBoard(SetupGame setupGame, Board board) {

        setupGame.createGame(board.getBoard(), board.getChancePile());

        setupGame.printBoard(board.getBoard());
    }

    /**
     * Testing the different methods and functions involving the chance pile
     * TODO: Not done
     */
    private static void testPrintChancePile(Board board, SetupGame setupGame) {

        setupGame.createGame(board.getBoard(), board.getChancePile());

        setupGame.printChancePile(board.getChancePile());
    }

    /**
     * Testing the different dice rolling methods and functions
     */
    private static void testDiceRolling(Scanner input,Player player) {
        System.out.println("Testing the dice rolling");
        System.out.println("How many eyes do you want your dice to have?");

        int eye = input.nextInt();
        String choices;

        player.chooceDice(eye);

        System.out.println("Lets start rolling!!");

        do {

            player.throwDice();
            System.out.println(player.yourRoll());
            System.out.println("Go again?");
            choices = input.next();

        } while (!choices.equals("n"));
    }

    /**
     * Testing different Property methods and functions
     */
    private static void testProperty(Player player){
        System.out.println("Testing the properties list and creation of objects");

        Property field = new Property("red", new int[]{5,10,20,30,40,100},100,0);
        field.setName("Voldens kvarter 1");
        field.setPawnValue(30);
        field.setOwned(false);

        Property field1 = new Property("red", new int[]{5,10,20,30,40,100},100,0);
        field1.setName("Voldens kvarter 2");
        field1.setPawnValue(100);
        field1.setOwned(false);

        Property field2 = new Property("red", new int[]{5,10,20,30,40,100},100,0);
        field2.setName("Voldens kvarter 3");
        field2.setPawnValue(200);
        field2.setOwned(false);

        player.getProperties().add(field);
        player.getProperties().add(field1);
        player.getProperties().add(field2);

        for (int i = 0; i < player.getProperties().size(); i++){
            System.out.println(player.getProperties().get(i));
        }

        int r = field.getRents()[0];

        System.out.println(r);
    }

    //------------------ TUI testing -----------------------------------------------------------------------------------

    private static void testTUI(Scanner scanner, Board board, SetupGame setupGame) throws InterruptedException {

        String input;
        int parsedInput1 = 0;

        setupGame.createGame(board.getBoard(), board.getChancePile());

        TUI.startup();

        while (true){

            TUI.mainMenu();

            while (true){

                do {

                    input = scanner.next();

                    try {

                        Integer.parseInt(input);

                        if (input.equals("2")){
                            System.out.println("Not implemented yet");
                        }else if (input.equals("1")){
                            System.out.println("Starting new game!!!");
                            break;
                        }else{
                            System.out.println("Wrong number!");
                        }


                    }catch (NumberFormatException e){
                        System.out.println("Not a number. Try again!");
                    }

                }while (true);

                TUI.preGameMenu();

                do {

                    input = scanner.next();

                    if (input.equals("quit") || input.equals("back")){
                        break;
                    }

                    try {
                        parsedInput1 = Integer.parseInt(input);

                        if (parsedInput1 >= 1 && parsedInput1 <= 6 ){
                            break;
                        }else {
                            System.out.println("Number out of range. Try again!");
                        }

                    }catch (NumberFormatException e){
                        System.out.println("Input not one of the required actions!");
                    }



                }while (true);

                if (input.equals("quit")){
                    System.out.println("Quitting!!!");
                    System.exit(0);
                }else if (input.equals("back")){
                    System.out.println("Going back to main menu!");
                    break;
                }else {

                    for (int i = 0; i < parsedInput1; i++) {
                        Player player = new Player();
                        System.out.println("Input name of player" + (i+1));
                        player.setName(scanner.next());
                        player.setWalletAmount(4000);
                        player.setPosition(new Random().nextInt(30));
                        board.getPlayers().add(player);
                    }

                    for(Player player : board.getPlayers()){
                        System.out.println(player);
                    }
                }

                for (int i = 0; i < board.getPlayers().size(); i++) {
                    Player player = board.getPlayers().get(i);
                    TUI.turnMenu(player,board);

                }
            }
        }
    }

    //------------------ BreweryLogic testing --------------------------------------------------------------------------

    private static void testPayRentBrewery(Board board, SetupGame setupGame, PayRentLogic payRentLogic, BuyFieldLogic buyFieldLogic){

        System.out.println("Creating game board!\n");
        setupGame.createGame(board.getBoard(),board.getChancePile());

        System.out.println("Creating 2 players!\n");
        Player p1 = new Player("Jacob",8000,0,false);
        Player p2 = new Player("Stella",8000,0,false);
        board.getPlayers().add(p1);
        board.getPlayers().add(p2);

        System.out.println("Setting up " + p1.getName() + "'s and " + p2.getName() + "'s dice!\n");
        p1.chooceDice(6);
        p2.chooceDice(6);

        Brewery cocaCola = (Brewery) board.getBoard()[12];
        Brewery tuborg = (Brewery) board.getBoard()[28];

        System.out.println("Placing " + p1.getName() + " on " + cocaCola.getName() + " field and buying it for " + cocaCola.getPrice() + " kr!\n");
        helperForTestPayRentBrewery(payRentLogic, buyFieldLogic, p1, p2, cocaCola, cocaCola);

        System.out.println("Placing " + p1.getName() + " on " + tuborg.getName() + " and purchasing it for " + tuborg.getPrice() + " kr!\n");
        helperForTestPayRentBrewery(payRentLogic, buyFieldLogic, p1, p2, cocaCola, tuborg);

        System.out.println("Test done!\n");

    }

    private static void helperForTestPayRentBrewery(PayRentLogic payRentLogic, BuyFieldLogic buyFieldLogic, Player p1, Player p2, Brewery cocaCola, Brewery tuborg) {
        p1.setPosition(tuborg.getPosition());

        if (tuborg.isOwned()){
            System.out.println(cocaCola.getName() + " is already owned! An error has occurred!");
            System.exit(-1);
        }else {
            buyFieldLogic.buyField(p1,tuborg);
        }

        System.out.println(p1.getName() + " property list has a size of " + p1.getProperties().size() + "\n" +
                p1.getName() + " property list contains the following:\n" + p1.getProperties() + "\n" +
                p1.getName() + "'s wallet contains now " + p1.getWalletAmount() + "\n");

        System.out.println(p2.getName() + " is throwing dice\n");

        p2.throwDice();
        System.out.println(p2.yourRoll());

        System.out.println("Moving " + p2.getName() + " to the " + tuborg.getName() + " field, and rent is due!\n");

        p2.setPosition(tuborg.getPosition());

        System.out.println(p2.getName() + "'s position on the board is " + p2.getPosition() + "\n" +
                p2.getName() + " is standing on the Brewery: " + tuborg.getName() + " that is owned by " + tuborg.getOwner().getName() + "\n" +
                p2.getName() + " have to pay: " + payRentLogic.showBreweryRent(p1,p2) + " kr\n");

        payRentLogic.payBreweryRent(p2,tuborg.getOwner(), tuborg);

        System.out.println(p2.getName() + " has a wallet amount of " + p2.getWalletAmount() + "\n" +
                p1.getName() + " has a wallet amount of " + p1.getWalletAmount() + "\n");
    }

    //------------------------- PayTaxLogic testing --------------------------------------------------------------------

    private static void testPayTaxLogic(Board board, SetupGame setupGame, PayTaxLogic payTaxLogic, Scanner scanner){

        //create player, board etc..
        Player player = new Player("Jacob", 10000, 0, false);
        setupGame.createGame(board.getBoard(), board.getChancePile());

        //move player to first tax field
        System.out.println("Moving player to field:\n" + board.getBoard()[4]);
        player.setPosition(4);
        System.out.println(player.getName() + " is now on the field: \n" + board.getBoard()[player.getPosition()]);

        if (player.getPosition() == 4 && !player.isInJail()){
            payTaxLogic.payTax(scanner, player);
        }else {
            System.out.println(player.getName()+ " is in the wrong position or is in jail!");
        }

        //print players wallet
        System.out.println("After " + player.getName() + " landed on the 1th tax field, his wallet contains " + player.getWalletAmount());

        //move player to second tax field
        System.out.println("Moving player to field:\n" + board.getBoard()[38]);
        player.setPosition(38);
        System.out.println(player.getName() + " is now on the field: \n" + board.getBoard()[player.getPosition()]);

        if (player.getPosition() == 38 && !player.isInJail()){
            payTaxLogic.payExtraTax(player);
        }else {
            System.out.println(player.getName()+ " is in the wrong position or is in jail!");
        }

        //print players wallet
        System.out.println("After " + player.getName() + " landed on the 1th tax field, his wallet contains " + player.getWalletAmount());

    }

    //--------------------- Pay property rent logic test ---------------------------------------------------------------

    private static void testPayRentProperty(SetupGame setupGame, Board board, PayRentLogic payRentLogic){

        //Make 4 players, board and Property's

        Property blue1, blue2, skin1, skin2, skin3, green1, green2, green3;

        setupGame.createGame(board.getBoard(), board.getChancePile());
        Player player1 = new Player("Jacob",20000,0,false);
        Player player2 = new Player("Stella",20000,0,false);
        Player player3 = new Player("Valdemar",20000,0,false);
        Player player4 = new Player("Leonora",20000,0,false);

        //Give 3 players som properties
        //player 2 gets 1 property
        //player 3 gets all properties with same color
        //player 4 gets all properties with same color and some houses
        //--------------------------------------------------------------------------------------------------------------

        Property[] blueProperties = giveProperty(new Property[]{null,null},player2,board,new int[]{1,3});

        blue1 = blueProperties[0];
        blue2 = blueProperties[1];

        System.out.println(player2.getName() + "'s property list, has size of: " + player2.getProperties().size() + "\n" +
                            "The properties color is: " + blue1.getColor() + "\n" +
                            "The properties are: " + blue1.getName() + " and " + blue2.getName() + "\n" +
                            "The rent for landing on " + blue2.getColor() + " is: " + payRentLogic.showPropertyRent(blue1,player2) + "\n");

        //--------------------------------------------------------------------------------------------------------------

        Property[] skinProperties = giveProperty(new Property[]{null, null, null},player3,board,new int[]{6,8,9});

        skin1 = skinProperties[0];
        skin2 = skinProperties[1];
        skin3 = skinProperties[2];

        System.out.println(player3.getName() + "'s property list has size of: " + player3.getProperties().size() + "\n" +
                            "The properties color are: \n" +
                            skin1.getName() + " is: " + skin1.getColor() + "\n" +
                            skin2.getName() + " is: " + skin2.getColor() + "\n" +
                            skin3.getName() + " is: " + skin3.getColor() + "\n" +
                            "The rent for landing on a property with color '" + skin3.getColor() + "' is now:\n" +
                            payRentLogic.showPropertyRent(skin1,player3) + " kr, for " + skin1.getName() + " or " + skin2.getName()  + "\n" +
                            payRentLogic.showPropertyRent(skin3,player3) + " kr, for " + skin3.getName() + "\n");

        //--------------------------------------------------------------------------------------------------------------

        Property[] greenProperties = giveProperty(new Property[]{null,null,null},player4,board,new int[]{11,13,14});

        green1 = greenProperties[0];
        green2 = greenProperties[1];
        green3 = greenProperties[2];

        System.out.println(player4.getName() + "'s property list has size of: " + player4.getProperties().size() + "\n" +
                            "The properties color are: \n" +
                            green1.getName() + " is: " + green1.getColor() + "\n" +
                            green2.getName() + " is: " + green2.getColor() + "\n" +
                            green3.getName() + " is: " + green3.getColor() + "\n" +
                            "The rent for landing on a property with color '" + green3.getColor() + "' is now:\n" +
                            payRentLogic.showPropertyRent(green1,player4) + " kr, for " + green1.getName() + " or " + green2.getName()  + "\n" +
                            payRentLogic.showPropertyRent(green3,player4) + " kr, for " + green3.getName() + "\n");

        System.out.println("Putting some houses on " + player4.getName() + "'s properties\n");

        green1.setHouses(1);
        green2.setHouses(2);
        green3.setHouses(3);

        System.out.println("The rent for " + player4.getName() + "'s properties is now:\n" +
                            green1.getName() + " has " + green1.getHouses() + " house\n" +
                            green2.getName() + " has " + green2.getHouses() + " houses\n" +
                            green3.getName() + " has " + green3.getHouses() + " houses\n" +
                            green1.getName() + " has a rent of " + payRentLogic.showPropertyRent(green1,player4) + " kr\n" +
                            green2.getName() + " has a rent of " + payRentLogic.showPropertyRent(green2,player4) + " kr\n" +
                            green3.getName() + " has a rent of " + payRentLogic.showPropertyRent(green3,player4) + " kr\n");

        //Move player 1 to the first player's property's and charge him rent
        System.out.println("Moving " + player1.getName() + " to " + blue1.getName() + " which is position " + blue1.getPosition() + " on the board!\n" +
                            blue1.getName() + " has a rent of: " + payRentLogic.showPropertyRent(blue1,blue1.getOwner()) + "\n");
        player1.setPosition(blue1.getPosition());

        System.out.println(player1.getName() + "'s position is now " + player1.getPosition() + "\n");

        System.out.println("Time to pay rent!\n");

        payRentLogic.payPropertyRent(player1, blue1.getOwner(), blue1);

        System.out.println(player1.getName() + "'s wallet contains " + player1.getWalletAmount() + "\n" +
                            player2.getName() + "'s wallet contains " + player2.getWalletAmount() + "\n");


        //Move player 1 to the second players property and charge him rent

        helperForPayRentLogic(payRentLogic, skin1, player1);

        player1.setPosition(skin3.getPosition());

        System.out.println("Moving " + player1.getName() + " to the third '" + skin3.getColor() + "' field, and charging rent.\n" +
                skin3.getName() + " has a position on the board now of " + skin3.getPosition() + "\n" +
                "The owner of " + skin3.getName() + " is " + skin3.getOwner().getName() + "\n" +
                "The rent is: " + payRentLogic.showPropertyRent(skin3, skin3.getOwner()) + "\n");

        System.out.println("Time to pay rent!\n");

        payRentLogic.payPropertyRent(player1,skin3.getOwner(),skin3);

        System.out.println(player1.getName() + " has " + player1.getWalletAmount() + " in his wallet!\n" +
                skin3.getOwner().getName() + " has " + skin3.getOwner().getWalletAmount() + " in the wallet!\n");


        //Move player 1 to the third players property and charge him rent

        helperForPayRentLogic(payRentLogic, green1, player1);

        //TODO try with more houses and a hotel



    }

    private static void helperForPayRentLogic(PayRentLogic payRentLogic, Property skin1, Player player1) {
        player1.setPosition(skin1.getPosition());
        System.out.println("Moving " + player1.getName() + " to the first '" + skin1.getColor() + "' field, and charging rent.\n" +
                skin1.getName() + " has a position on the board now of " + skin1.getPosition() + "\n" +
                            "The owner of " + skin1.getName() + " is " + skin1.getOwner().getName() + "\n" +
                            "The rent is: " + payRentLogic.showPropertyRent(skin1,skin1.getOwner()) + "\n");

        System.out.println("Time to pay rent!\n");

        payRentLogic.payPropertyRent(player1, skin1.getOwner(), skin1);

        System.out.println(player1.getName() + " has " + player1.getWalletAmount() + " in his wallet!\n" +
                skin1.getOwner().getName() + " has " + skin1.getOwner().getWalletAmount() + " in the wallet!\n");
    }

    private static Property[] giveProperty(Property[] properties, Player player, Board board, int[] fieldNumbers){

        System.out.println("Giving " + player.getName() + " a set of properties with same color!\n");

        for (int i = 0; i < properties.length; i++) {
            player.getProperties().add((BuyableField) board.getBoard()[fieldNumbers[i]]);
            properties[i] = (Property) player.getProperties().get(i);
            properties[i].setOwner(player);

        }
        return properties;
    }

    //------------------------------- Pay Shipping company rent logic test ---------------------------------------------

    private static void testPayFerryCompanyRentLogic(SetupGame setupGame, Board board, PayRentLogic payRentLogic, BuyFieldLogic buyFieldLogic){

        //Setting up the test
        System.out.println("Setting up board!!\n");
        setupGame.createGame(board.getBoard(), board.getChancePile());

        //Creating players
        System.out.println("Creating the five players!!\n");
        Player jacob = new Player("Jacob",10000,0,false);
        Player stella = new Player("Stella",10000,0,false);
        Player valdemar = new Player("Valdemar",10000,0,false);
        Player leonora = new Player("Leonora",10000,0,false);
        Player kida = new Player("Kida",10000,0,false);

        FerryCompany dfds = (FerryCompany) board.getBoard()[5];
        FerryCompany dsbKBH = (FerryCompany) board.getBoard()[15];
        FerryCompany sfl = (FerryCompany) board.getBoard()[25];
        FerryCompany dsbJylland = (FerryCompany) board.getBoard()[35];

        //Moving stella to the first Shipping Company and making stella buy it
        System.out.println(stella.getName() + " is moving to the first Shipping company, called: " + dfds.getName());

        //Moving player1 to the first shipping company to pay rent

        //Erase player2 and reset player1

        //Making player3 buy two Shipping Companies by moving him to the first and then the second

        //Moving player1 to the second Shipping Company to pay rent

        //Erase player3 and reset player1

        //Making player4 buy three Shipping Companies by moving player4 to the first, the second and then the third

        //Moving player1 to the third Shipping Company to pay rent

        //Erase player4 and reset player1

        //Making player5 buy four Shipping Companies by moving player 5 to the first, the second, the third and then the fourth

        //Moving player1 to the fourth Shipping Company to pay rent

    }

    //------------------------------ Chance card testing ---------------------------------------------------------------

    private static void testChanceCardLogic(){

    }


}

