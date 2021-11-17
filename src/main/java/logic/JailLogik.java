package logic;

import model.DiceCup;
import model.Player;

import java.util.Scanner;

public class JailLogik {

    public void goToJail(Player player) {

        if (player.getPosition() == 30) {
            player.setPosition(10); // it is position 10 not 11 because array board starts at 0 not 1
            player.setInJail(true);
        }
    }

    public boolean getOutOfJail(Scanner scanner, Player player) {

        int tries = 2;
        String input;

        while (tries != 0) {
            System.out.println("Press 1 to roll the dices!");
            input = scanner.next();

            try {
                Integer.parseInt(input);

                if (input.equals("1")) {
                    System.out.println("Rolling");
                    player.throwDice();
                    System.out.println(player.yourRoll());
                    if (player.getDiceCup().getDice1().getValue() == player.getDiceCup().getDice2().getValue()) {
                        System.out.println("You are free from jail and may continue!");
                        player.setInJail(false);
                        System.out.println("Player jail status: " + player.isInJail());
                        return true;
                    } else {
                        System.out.println("Dice were not equal. Try again!");
                        tries = tries - 1;
                    }
                } else {
                    System.out.println("Wrong input. Try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Try again!");
            }
        }
        System.out.println("You used up your tries. You are still in jail");
        return false;
    }
}
