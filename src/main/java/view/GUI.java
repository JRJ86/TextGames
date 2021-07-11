package view;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public void startScreen(JFrame frame){

    }

    public void mainMenu(){

    }

    public void characterCreation(JFrame frame){


    }

    public void gameScreen(JFrame frame, JMenuBar menuBar){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1000);

        JMenu menu1 = new JMenu("Game");
        JMenu menu2 = new JMenu("Help");
        menuBar.add(menu1);
        menuBar.add(menu2);

        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save");
        menu1.add(menuItem1);
        menu1.add(menuItem2);

        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.setVisible(true);



    }

    public void createGUI(JFrame frame){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Truly full screen
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);
        //custom full screen

        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);


    }

}
