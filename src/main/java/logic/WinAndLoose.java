package logic;

import model.Board;
import model.Player;

public class WinAndLoose {

    public boolean winConditions(Board board){

        for (Player player: board.getPlayers()) {
            
        }


        return false;
    }

    public boolean looseConditions(Player player){

        if (player.getWalletAmount() <= 0){
            if (player.getProperties().isEmpty()){
                System.out.println("Player " + player.getName() + " has no properties to pawn, and has lost the game!");
                return true;
            }
        }
        return false;
    }
}
