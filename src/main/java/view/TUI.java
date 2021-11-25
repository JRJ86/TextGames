package view;

import model.Board;
import model.Player;
import model.fields.BuyableField;

import javax.swing.*;
import java.util.ArrayList;

public class TUI {

    /**
     * The first that will load when starting the game
     *
     * @throws InterruptedException because of sleep function
     */
    public void startup() throws InterruptedException {

        System.out.println("-------------------------------------------------------------------------------------------\n" +
                           "|                                                                                         |\n" +
                           "|                                                                                         |\n" +
                           "|                                  WELCOME TO MATADOR                                     |\n" +
                           "|                                                                                         |\n" +
                           "|                         BECOME THE ULTIMATE MONOPOLY IN TOWN                            |\n" +
                           "|                                                                                         |\n" +
                           "|                                                                                         |\n" +
                           "-------------------------------------------------------------------------------------------");

//        Thread.sleep(500);
//        System.out.println("\n");
//
//        for (int i = 0; i < 10; i++){
//        System.out.println("                                   Loading: " + i * 10 + " %");
//            Thread.sleep(500);
//        }
//        System.out.println("                                   Loading: 100 %\n");
//        System.out.println("                                   Starting main menu!\n");

    }

    /**
     * The main menu
     */
    public void mainMenu(){
        System.out.println("-------------------------------------------------------------------------------------------\n" +
                           "|                                                                                         |\n" +
                           "|                                    Main Menu                                            |\n" +
                           "|                                                                                         |\n" +
                           "|                           Press '1' to start a new game!                                |\n" +
                           "|                           Press '2' to load a saved game!                               |\n" +
                           "|                           Press '3' to go to the previous menu!                         |\n" +
                           "|                                                                                         |\n" +
                           "-------------------------------------------------------------------------------------------\n");
    }

    /**
     * Choose how many players you want to play
     */
    public void preGameMenu(){
        System.out.println("-------------------------------------------------------------------------------------------\n" +
                           "|                                                                                         |\n" +
                           "|                  Input how many players there will be in the game (MAX 6)!              |\n" +
                           "|                                                                                         |\n" +
                           "|                  Type 'back' to go to the main menu!                                    |\n" +
                           "|                  Type 'quit' to quit the game!                                          |\n" +
                           "|                                                                                         |\n" +
                           "-------------------------------------------------------------------------------------------\n");
    }

    /**
     *
     * * This will display a menu where the player can:
     *
     *   - Check his properties
     *   - Roll dice and take turn
     *   - Buy houses or hotels
     *   - Save the game
     *   - Quit the game
     *
     *    TODO: maybe add more actions a player can do?
     *
     * @param player The player whose turn it is
     * @param board the game board
     */
    public void turnMenu(Player player, Board board){
        System.out.println("-------------------------------------------------------------------------------------------\n" +
                           "\n" +
                           "                            Player is: " + player.getName().toUpperCase() + "\n" +
                           "\n" +
                           "-------------------------------------------------------------------------------------------\n" +
                           "\n" +
                           "                            Player cash balance: " + player.getWalletAmount() +"\n" +
                           "                            Player position on the board: " + player.getPosition() + "\n" +
                           "                            Player is the field: " + board.getBoard()[player.getPosition()].getName() + "\n" +
                           "\n" +
                           "\n" +
                           "\n" +
                           "---------------------------     ---------------------------     ---------------------------\n" +
                           "|         Press 1:        |     |         Press 2:        |     |         Press 3:        |\n" +
                           "|     Roll the dice!!     |     |   See your properties!  |     |   Buy houses or hotel!  |\n" +
                           "---------------------------     ---------------------------     ---------------------------\n" +
                           "\n" +
                           "---------------------------     ---------------------------     ---------------------------\n" +
                           "|         Press 4:        |     |         Press 5:        |     |         Press 6:        |\n" +
                           "|     Pawn properties!    |     |     Save and quit!      |     |     Quit or give up!    |\n" +
                           "---------------------------     ---------------------------     ---------------------------\n" +
                           "\n");
    }

    public void printOwnedFields(ArrayList<BuyableField> ownedFields, Player player){
        
        if (ownedFields.isEmpty()){
            System.out.println(player.getName() + " does not own any properties!");
        }else {
            for (BuyableField field : ownedFields) {
                System.out.println(field);
            }
        }
    }


}
