package logic;

import model.Board;
import model.Player;
import model.fields.Parking;

public class ParkingLogic {

    public void retrieveParkingMoney(Player player, Board board){

        Parking parking = (Parking) board.getBoard()[20];
        int parkingMoney = board.getParkingMoney();

        if (player.getPosition() == parking.getPosition()){
            if (parkingMoney > 0){
                player.setWalletAmount(player.getWalletAmount() + parkingMoney);
                board.setParkingMoney(0);
            }else {
                System.out.println("There are no money in the parking lot!");
            }
        }
    }
}
