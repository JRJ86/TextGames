package model.fields;

public class Brewery extends BuyableField{

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "               Brewery: " + getName() + " \n\n" +
                "               The price is: " + getPrice() + " kr\n\n" +
                "               Owning 1 Brewery: \n" +
                "               Visiting player pays 100 times the dice values \n\n" +
                "               Owning 2 breweries: \n" +
                "               Visiting player pays 200 times the dice values \n\n" +
                "               You can pawn it for: " + getPawnValue() + " kr\n" +
                "-------------------------------------------------------------------------------- \n";
    }
}
