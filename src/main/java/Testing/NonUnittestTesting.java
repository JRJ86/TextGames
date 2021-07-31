package Testing;

import logic.BreweryLogic;
import logic.JailLogik;
import controller.SetupGame;
import model.Board;
import model.Player;
import model.fields.*;
import view.TUI;

import java.util.Random;
import java.util.Scanner;

public class NonUnittestTesting {

    public static void test() throws InterruptedException {

        Player p1 = new Player();
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        SetupGame setupGame = new SetupGame();
        ChanceField chanceField = new ChanceField();
        JailLogik jailLogik = new JailLogik();

//        setupGame.createGame(board.getBoard(),board.getChancePile());

        while (true){

            System.out.println("Which test do you want to run? \n\n" +
                    "1: Test property methods and functions\n" +
                    "2: Test dice rolling methods and functions\n" +
                    "3: Print the chance pile\n" +
                    "4: Print the board\n" +
                    "5: Test JailLogic methods\n" +
                    "6: Test TUI menu's\n" +
                    "7: Test BreweryLogic methods\n" +
                    "8: Test PayTaxLogic methods\n");

            int choice = input.nextInt();
            while (true){
                switch (choice){
                    case 1:
                        testProperty(p1);
                        break;
                    case 2:
                        testDiceRolling(input,p1);
                        break;
                    case 3:
                        testPrintChancePile(board,setupGame);
                        break;
                    case 4:
                        testPrintBoard(setupGame,board);
                        break;
                    case 5:
                        testGetOutOfJail(board,setupGame,jailLogik,input);
                        break;
                    case 6:
                        testTUI(input,board,setupGame);
                        break;
                    case 7:
                        testBreweryLogic(input,board,setupGame);
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Not a valid test number!!");
                        break;

                }
                System.out.println("If you want to run a different test press 'new'!");
                System.out.println("If you want to quit press 'exit'! \n");
                System.out.println("To run test again press random key! \n");
                String choice2 = input.next();

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

        Property field = new Property("red", new int[]{5,10,20,30,40,100},100,0, false);
        field.setName("Voldens kvarter 1");
        field.setPawnValue(30);
        field.setOwned(false);

        Property field1 = new Property("red", new int[]{5,10,20,30,40,100},100,0, false);
        field1.setName("Voldens kvarter 2");
        field1.setPawnValue(100);
        field1.setOwned(false);

        Property field2 = new Property("red", new int[]{5,10,20,30,40,100},100,0, false);
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
                    Thread.sleep(500);

                }
            }
        }
    }

    private static void testBreweryLogic(Scanner scanner, Board board, SetupGame setupGame){

        System.out.println("Creating game board!!");
        setupGame.createGame(board.getBoard(),board.getChancePile());

        System.out.println("Creating 2 players!!");
        for (int i = 0; i < 2; i++) {
            Player player = new Player(scanner.next(),4000,0,false);
            board.getPlayers().add(player);
        }

        while (true){

            System.out.println("Setting the first player on the Coca cola field!");
            board.getPlayers().get(0).setPosition(12);
            System.out.println(board.getPlayers().get(0).getName() + "'s position on the board is: " + board.getPlayers().get(0).getPosition());

            if (!((Brewery) board.getBoard()[12]).isOwned()){

                System.out.println("Adding property to " + board.getPlayers().get(0).getName() + "'s properties!");
                board.getPlayers().get(0).getProperties().add((BuyableField) board.getBoard()[12]);
                ((Brewery) board.getBoard()[12]).setOwned(true);
                break;

            }else {
                System.out.println("Another player owns this property");
            }
        }

        System.out.println("Printing all properties:");
        for (BuyableField field: board.getPlayers().get(0).getProperties()) {
            System.out.println(field);
        }










    }

    private static void testPayTaxLogic(){


    }
}
