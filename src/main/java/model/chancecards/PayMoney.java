package model.chancecards;

public class PayMoney extends ChanceCard{

    private int amount;

    public PayMoney(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "                       CHANCE CARD \n\n" +
                "                       " + getDescription() + "\n\n" +
                "                       Pay " + amount + " kr to the bank! \n" +
                "-------------------------------------------------------------------------------- \n";
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
