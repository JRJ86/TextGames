package logic;

import model.Board;
import model.Player;
import model.chancecards.ChanceCard;
import model.chancecards.GetMoney;
import model.chancecards.MatadorGrant;
import model.chancecards.PayMoney;
import java.util.Queue;

public class ChanceCardLogic {

    public void triggerChanceCard(Player player, Board board){

        // check if player is standing on one of the
        do {

            int x = -1;

            for (Integer integer: board.getChancePositions()) {
                if (player.getPosition() == integer){
                    x = integer;
                    break;
                }
            }

            if (player.getPosition() == x){
                System.out.println(player.getName() + " is standing on position " + x + "\n" +
                        "That is " + board.getBoard()[x].getName() + "\n");
                break;
            }else {
                System.out.println(player.getName() + " is not standing on a chance field!!\n");
            }

        }while(true);

        // draw a card
        ChanceCard chanceCard = drawCard(board.getChancePile());

        // check what card it is
        if (chanceCard instanceof GetMoney){
            System.out.println(chanceCard.getDescription() + "\n" +
                    "The amount to get is " + ((GetMoney) chanceCard).getAmount() + "\n");
            getMoneyFun(player, (GetMoney) chanceCard);

        }else if (chanceCard instanceof PayMoney){
            System.out.println(chanceCard.getDescription() + "\n" +
                    "The amount to pay is " + ((PayMoney) chanceCard).getAmount() + "\n");
            payMoneyFun(player, (PayMoney) chanceCard, board);

        }else if (chanceCard instanceof MatadorGrant){
            System.out.println("Not implemented yet!");

        }else {
            System.err.println("Something went wrong!");

        }
    }

    /**
     * TODO Properly test it
     * @param pile The Chance card deck
     * @return The top card, use it and then remove it
     */
    private ChanceCard drawCard(Queue<ChanceCard> pile){
        ChanceCard card = pile.peek();
        pile.poll();
        return card;
    }

    private void getMoneyFun(Player player, GetMoney getMoney){
        player.setWalletAmount(player.getWalletAmount() + getMoney.getAmount());
    }

    private void payMoneyFun(Player player, PayMoney payMoney, Board board){
        int toParkingFee = payMoney.getAmount();
        player.setWalletAmount(player.getWalletAmount() - toParkingFee);
        board.setParkingMoney(board.getParkingMoney() + toParkingFee);
    }

}
