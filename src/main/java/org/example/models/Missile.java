package org.example.models;

import org.example.strategies.MissileBehavior;

public abstract class Missile {
    private String name;
    private int damage;
    private MissileBehavior behavior;

    public Missile(String name, int damage, MissileBehavior behavior) {
        this.name = name;
        this.damage = damage;
        this.behavior = behavior;
    }

    public void executeBehavior(int targetX, int targetY, Cell[][] board) {
        behavior.fire(targetX, targetY, board);
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}