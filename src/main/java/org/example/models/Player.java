package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Ship> ships;
    private boolean isTurn;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
        this.isTurn = false;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public String getName() {
        return name;
    }

    public boolean hasShipsLeft() {
        for (Ship ship : ships) {
            if (!ship.isDestroyed()) {
                return true;
            }
        }
        return false;
    }

    //here I am choosing the first missile and firing
    //todo: a missile choosing STRATEGY should be implemented
    public Missile chooseMissile() {
        for (Ship ship : ships) {
            if (!ship.isDestroyed()) {
                List<Missile> armory = ship.getArmory();
                for (Missile missile : armory) {
                    armory.remove(missile);
                    return missile;
                }
            }
        }
        return null;
    }

    public boolean hasMissileLeft() {
        for (Ship ship : ships) {
            if (!ship.isDestroyed()) {
                List<Missile> armory = ship.getArmory();
                if (!armory.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}
