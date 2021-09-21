package model;

import model.chancecards.ChanceCard;
import model.fields.BuyableField;
import model.fields.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Board {

    private Field[] board = new Field[40];
    private Queue<ChanceCard> chancePile = new LinkedList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<Integer> chancePositions = new ArrayList<>(Arrays.asList(2,7,17,22,33,36));
    private int parkingMoney;

    public Board(){

    }

    //------------------- Getters & Setters ----------------------------------------------------------------------------


    public Queue<ChanceCard> getChancePile() {
        return chancePile;
    }

    public void setChancePile(Queue<ChanceCard> chancePile) {
        this.chancePile = chancePile;
    }

    public Field[] getBoard() {
        return board;
    }

    public void setBoard(Field[] board) {
        this.board = board;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Integer> getChancePositions() {
        return chancePositions;
    }

    public int getParkingMoney() {
        return parkingMoney;
    }

    public void setParkingMoney(int parkingMoney) {
        this.parkingMoney = parkingMoney;
    }
}
