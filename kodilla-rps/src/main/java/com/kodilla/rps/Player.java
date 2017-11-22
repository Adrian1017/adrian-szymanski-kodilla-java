package com.kodilla.rps;

public class Player {
    private String name;
    private int numberOfPoints;
    private Hand hand;

    public Player(String name) {
        this.name = name;
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

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
