package model;

import model.chancecards.ChanceCard;
import model.fields.BuyableField;
import model.fields.Field;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Board {

    private Field[] board = new Field[40];
    private BuyableField[] buyableFields = new BuyableField[28]; //TODO: TEST
//    private ChanceCard[] chancePile = new ChanceCard[17];
    private Queue<ChanceCard> chancePile = new LinkedList<>();
    private ArrayList<Player> players = new ArrayList<>();

    public Board(){

    }

    //------------------- Getters & Setters ----------------------------------------------------------------------------


    public Queue<ChanceCard> getChancePile() {
        return chancePile;
    }

    public void setChancePile(Queue<ChanceCard> chancePile) {
        this.chancePile = chancePile;
    }


//    public ChanceCard[] getChancePile() {
//        return chancePile;
//    }
//
//    public void setChancePile(ChanceCard[] chancePile) {
//        this.chancePile = chancePile;
//    }

    public Field[] getBoard() {
        return board;
    }

    public void setBoard(Field[] board) {
        this.board = board;
    }

    public BuyableField[] getBuyableFields() {
        return buyableFields;
    }

    public void setBuyableFields(BuyableField[] buyableFields) {
        this.buyableFields = buyableFields;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
