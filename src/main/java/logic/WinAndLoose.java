package logic;

import model.Board;
import model.Player;

public class WinAndLoose {

    public boolean winConditions(Board board, Player focusedPlayer){

        // If player is the last in game
        if (board.getPlayers().size() <= 1 && board.getPlayers().get(0) == focusedPlayer){
            System.out.println("Player " + focusedPlayer.getName() + " is the last player in the game and has therefore won!");
            return true;
        }else {
            return false;
        }
    }

    public boolean looseConditions(Player player){

        // If player loses all money and have noe pawn-able properties left
        if (player.getWalletAmount() <= 0 && player.getProperties().isEmpty()){
            System.out.println("Player " + player.getName() + " has no properties to pawn, and has lost the game!");
            return true;
        }else {
            return false;
        }
    }
}
