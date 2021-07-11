package controller;

import model.DiceCup;
import model.Player;

public class JailLogik {

    public void goToJail(Player player){

        if (player.getPosition() == 30){
            player.setPosition(10); // it is position 10 not 11 because array board starts at 0 not 1
            player.setInJail(true);
        }

    }

    /**
     * TODO: is bugged. maybe remove it
     *
     */
    public boolean isDiceEqual(DiceCup diceCup){
        return diceCup.getDice1() == diceCup.getDice2();
    }

}
