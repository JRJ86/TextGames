package model.fields;

import model.Player;

public class Start extends Field{

    public Start() {
    }

    /**
     * Player will get 4000 kr when passing start
     * TODO: If player lands on Start get 8000 kr
     * @param player
     */
    public void passStart(Player player){
        int amount = player.getWalletAmount();
        int amountAfterStart = amount + 4000;
        player.setWalletAmount(amountAfterStart);
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "                           This is the starting area.\n" +
                "                Every time you pass Start you will collect 4000 kr. \n" +
                "                If you land on Start you will collect 8000 kr. \n" +
                "-------------------------------------------------------------------------------- \n";
    }
}
