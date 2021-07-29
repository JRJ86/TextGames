package logic;

import model.Player;

public class BreweryLogic {

    public void payHundredTimes(Player player){
        int amount = player.getWalletAmount();
        int diceValue = player.getCurrentRoll();
        int diceValue2 = diceValue * 100;
        player.setWalletAmount(amount - diceValue2);
    }

    public void payTwoHundredTimes(Player player){
        int amount = player.getWalletAmount();
        int diceValue = player.getCurrentRoll();
        int diceValue2 = diceValue * 200;
        player.setWalletAmount(amount - diceValue2);
    }
}
