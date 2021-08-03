package logic;

import model.Player;

public class BreweryLogic {

    public void payHundredTimes(Player p1, Player p2){
        int amount1 = p1.getWalletAmount();
        int amount2 = p2.getWalletAmount();
        int diceValue = p1.getCurrentRoll();
        int diceValue2 = diceValue * 100;
        p1.setWalletAmount(amount1 - diceValue2);
        p2.setWalletAmount(amount2 + diceValue2);
    }

    public void payTwoHundredTimes(Player p1, Player p2){
        int amount1 = p1.getWalletAmount();
        int amount2 = p2.getWalletAmount();
        int diceValue = p1.getCurrentRoll();
        int diceValue2 = diceValue * 200;
        p1.setWalletAmount(amount1 - diceValue2);
        p2.setWalletAmount(amount2 + diceValue2);
    }
}
