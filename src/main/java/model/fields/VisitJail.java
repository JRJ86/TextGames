package model.fields;

public class VisitJail extends Jail{

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "                          VISIT JAIL or GET OUT OF JAIL \n\n" +
                "              If you want out of jail you have to throw a pair of dices, \n" +
                "              and get the same eyes on both. You have two tries each turn.\n" +
                "-------------------------------------------------------------------------------- \n";
    }
}
