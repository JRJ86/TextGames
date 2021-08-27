package logic;

import model.Player;
import model.fields.BuyableField;

public class BuyFieldLogic {

    public void buyField(Player player, BuyableField buyableField){

        int price = buyableField.getPrice();
        int pawnPrice = buyableField.getPawnValue();

        if (player.getWalletAmount() > pawnPrice && buyableField.isPawned()){
            player.setWalletAmount(player.getWalletAmount() - pawnPrice);
            player.getProperties().add(buyableField);
            buyableField.setOwned(true);
            buyableField.setOwner(player);
        }else if (player.getWalletAmount() > price && !buyableField.isOwned()) {
            player.setWalletAmount(player.getWalletAmount() - price);
            player.getProperties().add(buyableField);
            buyableField.setOwned(true);
            buyableField.setOwner(player);
        }else {
            System.out.println(player.getName() + " does not have enough money to buy " + buyableField.getName());
        }
    }

}

