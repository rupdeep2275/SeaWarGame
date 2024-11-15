package org.example.models;

public class Cell {
    private Ship ship;

    public Ship getShip() {
        return ship;
    }

    public void placeShip(Ship ship) {
        this.ship = ship;
    }
}

