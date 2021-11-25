package controller;

import model.Player;
import view.TUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    public void startupGame(TUI tui, Scanner scanner) {
        try {
            tui.startup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String input;
        int inputtedNumber = 0;

        tui.mainMenu();
        input = scanner.next();

        do {
            try {
                inputtedNumber = Integer.parseInt(input);

                switch (inputtedNumber) {
                    case 1:
                        System.out.println("you inputted " + input);
                        break;
                    case 2:
                        System.out.println("You inputted " + input);
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

    public void turn(Player player){

    }

}
