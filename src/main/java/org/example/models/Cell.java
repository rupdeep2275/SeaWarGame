package org.example.models;

public class Cell {
    private Ship ship;
    private boolean isHit;

    public boolean hasShip() {
        return ship != null;
    }

    public Ship getShip() {
        return ship;
    }

    public void placeShip(Ship ship) {
        this.ship = ship;
    }

    public void hit(int damage) {
        if (ship != null) {
            ship.takeDamage(damage);
            isHit = true;
        }
    }
}

