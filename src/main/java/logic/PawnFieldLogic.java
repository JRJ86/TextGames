package logic;

import model.Player;
import model.fields.BuyableField;

public class PawnFieldLogic {

    public void pawnField(Player owner, BuyableField buyableField){
        if (buyableField.isOwned() && buyableField.getOwner() == owner){

            int pawnValue = buyableField.getPawnValue();
            owner.setWalletAmount(owner.getWalletAmount() + pawnValue);

            buyableField.setOwner(null);
            buyableField.setOwned(false);
            buyableField.setPawned(true);
            owner.getProperties().remove(buyableField);
        }else {
            System.err.println("You cant pawn a field if you dont own it!!!");
        }
    }
}
