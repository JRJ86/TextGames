package view;

import model.Player;

public class TUI {

    /**
     * The first that will load when starting the game
     *
     * @throws InterruptedException because of sleep function
     */
    public static void startup() throws InterruptedException {

        System.out.println("-------------------------------------------------------------------------------------------\n" +
                           "|                                                                                         |\n" +
                           "|                                                                                         |\n" +
                           "|                                  WELCOME TO MATADOR                                     |\n" +
                           "|                                                                                         |\n" +
                           "|                         BECOME THE ULTIMATE MONOPOLY IN TOWN                            |\n" +
                           "|                                                                                         |\n" +
                           "|                                                                                         |\n" +
                           "-------------------------------------------------------------------------------------------");

        Thread.sleep(500);
        System.out.println("\n");

        for (int i = 0; i < 10; i++){
        System.out.println("                                   Loading: " + i * 10 + " %");
            Thread.sleep(500);
        }
        System.out.println("                                   Loading: 100 %\n");
        System.out.println("                                   Starting main menu!\n");

    }

    /**
     * The main menu
     */
    public static void mainMenu(){
        System.out.println("-------------------------------------------------------------------------------------------\n" +
                           "|                                                                                         |\n" +
                           "|                                    Main Menu                                            |\n" +
                           "|                                                                                         |\n" +
                           "|                           Press '1' to start a new game!                                |\n" +
                           "|                           Press '2' to load a saved game!                               |\n" +
                           "|                                                                                         |\n" +
                           "-------------------------------------------------------------------------------------------\n");
    }

    /**
     * Choose how many players you want to play
     */
    public static void preGameMenu(){
        System.out.println("-------------------------------------------------------------------------------------------\n" +
                           "|                                                                                         |\n" +
                           "|                  Input how many players there will be in the game!                      |\n" +
                           "|                                                                                         |\n" +
                           "|                  To go back to the main menu type 'back'!                               |\n" +
                           "|                  To quit the game press 'quit'!                                         |\n" +
                           "|                                                                                         |\n" +
                           "-------------------------------------------------------------------------------------------\n");
    }

    /**
     * This will display a menu where the player can:
     *  - Check his properties
     *  - Roll dice and take turn
     *  - Buy houses or hotels
     *  -
     */
    public static void turnMenu(Player player){

    }



}
