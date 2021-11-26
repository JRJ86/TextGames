package controller;

import model.Board;
import model.Player;
import view.TUI;

import java.util.Scanner;

public class GameController {

    public void startupGame(TUI tui, Scanner scanner, Board board) {
        try {
            tui.startup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainMenu(tui,scanner,board);
    }

    private void mainMenu(TUI tui, Scanner scanner,Board board){

        String input;
        int inputtedNumber = 0;

        tui.mainMenu();
        input = scanner.next();

        do {
            try {
                inputtedNumber = Integer.parseInt(input);

                switch (inputtedNumber) {
                    case 1:
                        startGame(tui,scanner,board);
                        break;
                    case 2:
                        System.out.println("You inputted " + input + ". The load game service is not implemented yet!");
                        break;
                    case 3:
                        StartOfSystem.start();
                        break;
                }

            }catch (NumberFormatException e){
                System.err.println("Input has to be a number!");

            }

            tui.mainMenu();
            input = scanner.next();

        }while (true);
    }

    private void startGame(TUI tui, Scanner scanner, Board board){

        String input;
        int inputtedNumber = 0;

        tui.preGameMenu();
        input = scanner.next();

        do {
            switch (input) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    try {
                        inputtedNumber = Integer.parseInt(input);
                    }catch (NumberFormatException e){
                        System.err.println("Something went wrong. Input was not a number!");
                    }
                    choosePlayers(board,inputtedNumber,scanner);
                    tui.displayPlayers(board);
                    System.out.println("Inputted number: " + inputtedNumber);
                    break;
                case "back":
                    mainMenu(tui,scanner,board);
                    break;
                case "quit":
                    System.out.println("Quitting!!");
                    System.exit(0);
                default:
                    System.out.println("Input one of the options listed!!");
                    break;
            }
            tui.preGameMenu();
            input = scanner.next();

        }while (true);

    }

    /**
     * TODO: Change the starting amount for players
     *
     * @param board
     * @param playerNumber
     * @param scanner
     */
    private void choosePlayers(Board board,int playerNumber,Scanner scanner){
        for (int i = 0; i < playerNumber; i++) {
            System.out.println("Input name of player " );
            Player player = new Player(scanner.next(), 10000,0,false,(i+1));
            board.getPlayers().add(player);
        }
    }

    public void turn(Player player){

    }

}
