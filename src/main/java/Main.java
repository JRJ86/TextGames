import model.Board;
import model.Player;
import model.fields.BuyableField;
import model.fields.ChanceField;
import model.fields.Property;
import controller.JailLogik;
import controller.SetupGame;

import java.util.Scanner;

import static Testing.NonUnittestTesting.test;
import static view.TUI.startup;

public class Main {

    public static void main(String[] args) {
//        JFrame frame = new JFrame("MATADOR");
//        JMenuBar menuBar = new JMenuBar();
//
//        GUI gui = new GUI();
//        gui.gameScreen(frame,menuBar);

        try {
            test();
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
