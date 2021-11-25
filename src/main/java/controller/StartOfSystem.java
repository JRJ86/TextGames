package controller;

import view.TUI;

import java.util.Scanner;

import static Testing.NonUnittestTesting.test;

public class StartOfSystem {

    public static void start(){

        Scanner scanner = new Scanner(System.in);
        TUI tui = new TUI();
        GameController controller = new GameController();
        String input;

        while (true){
            System.out.println("Press 1 to play the game in TUI mode.\n" +
                    "Press 2 to play the game in GUI mode.\n" +
                    "Press 3 to test the game.\n" +
                    "Press 4 to quit the game.\n");

            input = scanner.next();
            try {
                Integer.parseInt(input);

                switch (input) {
                    case "1":
                        controller.startupGame(tui,scanner);
                        break;
                    case "2":
                        System.out.println("GUI Not implemented yet!");
                        break;
                    case "3":
                        try {
                            test();
                        } catch (InterruptedException e) {
                            System.err.println(e.getMessage());
                        }
                        break;
                    case "4":
                        System.out.println("Quitting... Have a nice day!");
                        System.exit(0);
                    default:
                        System.err.println("You have to input 1, 2, 3 or 4!");
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("Input has to be a number!");
//                System.out.println(e.getLocalizedMessage());
//                e.printStackTrace();
            }
        }
    }
}
