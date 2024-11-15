package org.example.models;

import org.example.factories.MissileBehaviourFactory;
import org.example.strategies.MissileBehavior;

public abstract class Missile {
    private String type;
    private int damage;
    private MissileBehavior behavior;

    public Missile(String type, int damage, MissileBehaviourFactory missileFactory) {
        this.damage = damage;
        this.type = type;
        this.behavior = missileFactory.createMissileBehaviour(type);
    }

    public void executeBehavior(int targetX, int targetY, Cell[][] board) {
        behavior.fire(targetX, targetY, board);
    }
}