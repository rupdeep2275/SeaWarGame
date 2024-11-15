package org.example.models;

import java.util.List;

import java.util.ArrayList;

public abstract class Ship {
    private String name;
    private int health;
    private List<Missile> armory;

    public Ship(String name, int health) {
        this.name = name;
        this.health = health;
        this.armory = new ArrayList<>();
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been destroyed!");
        }
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    public List<Missile> getArmory() {
        return armory;
    }

    public String getName() {
        return name;
    }

    public abstract boolean addMissile(Missile missile);
}


