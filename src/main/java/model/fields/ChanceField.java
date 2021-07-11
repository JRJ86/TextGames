package model.fields;
import model.chancecards.ChanceCard;

import java.util.Queue;

public class ChanceField extends Field {

    public ChanceField() {
    }

    /**
     * TODO Properly test it
     * @param pile The Chance card deck
     * @return The top card, use it and then remove it
     */
    public ChanceCard drawCard(Queue<ChanceCard> pile){
        ChanceCard card = pile.peek();
        pile.poll();
        return card;
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
