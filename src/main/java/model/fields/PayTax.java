package model.fields;

public class PayTax extends Field{

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "                              PAY TAX!!\n\n" +
                "                  This is the " + getName() + " Field \n" +
                "                  Either: \n" +
                "                  - Pay 10 % of your current funds \n" +
                "                  - Pay 4000 kr \n" +
                "-------------------------------------------------------------------------------- \n";
    }
}
