package view;

public class TUI {

    public static void startup() throws InterruptedException {

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                         |");
        System.out.println("|                                                                                         |");
        System.out.println("|                                  WELCOME TO MATADOR                                     |");
        System.out.println("|                                                                                         |");
        System.out.println("|                         BECOME THE ULTIMATE MONOPOLY IN TOWN                            |");
        System.out.println("|                                                                                         |");
        System.out.println("|                                                                                         |");
        System.out.println("-------------------------------------------------------------------------------------------");
        Thread.sleep(500);
        System.out.println("\n");

        for (int i = 0; i < 10; i++){
        System.out.println("                                   Loading: " + i * 10 + " %");
            Thread.sleep(500);
        }
        System.out.println("                                   Loading: 100 %\n");
        System.out.println("                                   Starting main menu");

    }

    /**
     * The main menu
     *
     * It will only
     */
    public static void mainMenu(){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                         |");
        System.out.println("|                                    Main Menu                                            |");
        System.out.println("|                                                                                         |");
        System.out.println("|                                                                                         |");
        System.out.println("|                           Press '1' to start a new game!                                |");
        System.out.println("|                           Press '2' to load a saved game!                               |");
        System.out.println("|                                                                                         |");
        System.out.println("|                                                                                         |");
        System.out.println("-------------------------------------------------------------------------------------------");


    }

    /**
     * Choose how many players you want to play
     */
    public static void preGameMenu(){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                         |");
        System.out.println("|               Input how many players there will be in the game!                         |");
        System.out.println("|                                                                                         |");
        System.out.println("|               To go back to the main menu type 'back'!                                  |");
        System.out.println("|               To quit the game press 'quit'!                                            |");
        System.out.println("|                                                                                         |");
        System.out.println("-------------------------------------------------------------------------------------------");

    }

    /**
     * This will display a menu where the player can:
     *  - Check his properties
     *  - Roll dice
     *  - Buy houses
     *  -
     */
    public static void turnMenu(){

    }



}
