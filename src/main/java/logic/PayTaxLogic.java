package logic;

import model.Player;

public class PayTaxLogic {

    public void payTenProcent(Player player){
        int amount = player.getWalletAmount();
        int procent = (int) (amount * 0.10);
        player.setWalletAmount(amount - procent);
    }

    //TODO: TEST
    public void payMoney(Player player){
        int amount = player.getWalletAmount();
        player.setWalletAmount(amount - 4000);


        if (player.getWalletAmount() < 0){
            System.out.println("Player " + player.getName() + " are broke, and may now pawn some properties");
            if (player.getProperties().isEmpty()){
                System.out.println("Player " + player.getName() + " has no properties to pawn, and has lost the game!");
            }
        }
    }

    public void payExtraTax(Player player){
        int amount = player.getWalletAmount();
        player.setWalletAmount(amount - 2000);

        if (player.getWalletAmount() < 0){
            System.out.println("Player " + player.getName() + " are broke, and may now pawn some properties");
            if (player.getProperties().isEmpty()){
                System.out.println("Player " + player.getName() + " has no properties to pawn, and has lost the game!");
            }
        }
    }

}
