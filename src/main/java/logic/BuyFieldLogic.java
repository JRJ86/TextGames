package logic;

import model.Player;
import model.fields.BuyableField;

public class BuyFieldLogic {

    /**
     *
     *
     * @param buyer
     * @param buyableField
     */
    public void buyField(Player buyer, BuyableField buyableField){

        int price = buyableField.getPrice();
        int pawnPrice = buyableField.getPawnValue();

        if (buyer.getPosition() == buyableField.getPosition()){
            if (buyer.getWalletAmount() > pawnPrice && buyableField.isPawned()){
                buyer.setWalletAmount(buyer.getWalletAmount() - pawnPrice);
                buyer.getProperties().add(buyableField);
                buyableField.setOwned(true);
                buyableField.setOwner(buyer);
            }else if (buyer.getWalletAmount() > price && !buyableField.isOwned()) {
                buyer.setWalletAmount(buyer.getWalletAmount() - price);
                buyer.getProperties().add(buyableField);
                buyableField.setOwned(true);
                buyableField.setOwner(buyer);
            }else {
                System.out.println(buyer.getName() + " does not have enough money to buy " + buyableField.getName());
            }
        }else {
            System.err.println("Player is not standing on " + buyableField.getName() + " for some reason!");
        }
    }

    /**
     * This function releases a field from a player's ownership.
     * It can be used when:
     *
     * - A player wants to sell a BuyableField
     * - A player quits or loses the game and his fields need to be purchasable again
     *
     * @param owner The owning player
     * @param buyableField The field that is to be sold
     */
    public void releaseField(Player owner, BuyableField buyableField){

        if (buyableField.isOwned() && buyableField.getOwner() == owner){
            buyableField.setOwner(null);
            buyableField.setOwned(false);
            owner.getProperties().remove(buyableField);
        }
    }

    public void releasePlayersFields(Player owner){

        for (BuyableField field : owner.getProperties()) {
            field.setOwner(null);
            field.setOwned(false);
        }
        owner.getProperties().clear();
    }
}

