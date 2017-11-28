package com.kodilla.trps;

public class Player {

    private String name;
    private int numberOfPoints;
    private Move move;

    public Player(String name, int numberOfPoints) {
        this.name = name;
        this.numberOfPoints = numberOfPoints;
    }

    public String getName() {
        return name;
    }

    public void addPoint() {
        this.numberOfPoints++;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move hand) {
        this.move = hand;
    }

    @Override
    public String toString() {
        return "Player:" + name.toUpperCase() + " " +
                "Points:" + numberOfPoints;
    }
}
