package model.fields;
import model.chancecards.ChanceCard;

import java.util.Queue;

public class ChanceField extends Field {

    public ChanceField() {
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------------- \n" +
                "                       You have landed on " + getName() + ".\n\n" +
                "                             Try your luck!\n" +
                "           Take a card from the Chance deck and read it out loud. \n" +
                "        It can either be a blessing or a curse, but you have to do it. \n" +
                "-------------------------------------------------------------------------------- \n";
    }
}
