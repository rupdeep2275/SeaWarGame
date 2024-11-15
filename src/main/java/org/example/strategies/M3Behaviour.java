package org.example.strategies;

import org.example.models.Cell;
import org.example.models.Ship;

public class M3Behaviour implements MissileBehavior {
    private static final int DAMAGE = 15;

    @Override
    public void fire(int targetX, int targetY,Cell[][] board) {
        Cell targetCell = board[targetX][targetY];
        Ship ship = targetCell.getShip();
        if (ship != null) {
            ship.takeDamage(DAMAGE);
            System.out.println("Direct hit on " + ship.getName() + "! Damage: " + DAMAGE);
            if (ship.isDestroyed()) {
                System.out.println(ship.getName() + " is destroyed!");
            }
        } else {
            System.out.println("Miss! No ship at the target.");
        }
    }
}

