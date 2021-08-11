package logic;

import model.Player;

import java.util.Scanner;

public class PayTaxLogic {

    //-------------------------- Pay tax on field 4 in board array -----------------------------------------------------

    public void payTax(Scanner scanner, Player player){

        String input;

        System.out.println("How do you want to pay: \n" +
                           "Press 1 to pay 10 % of your cash!\n" +
                           "Press 2 to pay 4000 kr!");

        do {

            input = scanner.next();

            try {
                Integer.parseInt(input);

                if (input.equals("1")) {
                    payTenProcent(player);
                    break;

                }else if (input.equals("2")){
                    payMoney(player);
                    break;

                }else {
                    System.out.println("Wrong number. Try again!");
                }

            }catch (NumberFormatException e){
                System.out.println("Input was not a number. Input either of the numbers 1 and 2!");
            }
        }while (true);

    }

    private void payTenProcent(Player player){
        int amount = player.getWalletAmount();
        int procent = (int) (amount * 0.10);
        player.setWalletAmount(amount - procent);
    }

    private void payMoney(Player player){
        int amount = player.getWalletAmount();
        player.setWalletAmount(amount - 4000);
    }

    //-------------------------- Pay tax on field 38 in board array ----------------------------------------------------

    public void payExtraTax(Player player){
        int amount = player.getWalletAmount();
        player.setWalletAmount(amount - 2000);
    }

}
