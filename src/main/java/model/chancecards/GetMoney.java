package model.chancecards;

public class GetMoney extends ChanceCard{

    private int amount;

    public GetMoney(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "                       CHANCE CARD \n\n" +
                "                       " + getDescription() + "\n\n" +
                "                       Retrieve " + amount + " kr from the bank! \n" +
                "-------------------------------------------------------------------------------- \n";
    }

    //--------------------------- Getters & Setters --------------------------------------------------------------------

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
