package model.fields;

public class PayTaxes extends Field{

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "                             PAY YOUR TAXES!!\n\n" +
                "                  This is the " + getName() + " Field \n" +
                "                  Depending on the tax field, either: \n" +
                "                  - Pay 10 % of your current funds or 4000 kr. \n" +
                "                  - Pay 2000 kr \n" +
                "-------------------------------------------------------------------------------- \n";
    }
}
