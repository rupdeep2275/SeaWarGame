package org.example.strategies;

import org.example.models.*;

public class M1Behaviour implements MissileBehavior {
    private static final int TARGET_DAMAGE = 20;
    private static final int SPLASH_DAMAGE = 5;
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @Override
    public void fire(int targetX, int targetY, Cell[][] board) {
        //deal damage to the targeted cell
        Cell targetCell = board[targetX][targetY];
        Ship ship = targetCell.getShip();
        if (ship != null) {
            ship.takeDamage(TARGET_DAMAGE);
            System.out.println("Direct hit on " + ship.getName() + "! Damage: " + TARGET_DAMAGE);
            if (ship.isDestroyed()) {
                System.out.println(ship.getName() + " is destroyed!");
            }
        }

        //deal splash damage to adjacent cells
        for (int[] direction : directions) {
            int x = targetX + direction[0];
            int y = targetY + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                Cell adjacentCell = board[x][y];
                Ship adjacentShip = adjacentCell.getShip();
                if (adjacentShip != null) {
                    adjacentShip.takeDamage(SPLASH_DAMAGE);
                    System.out.println("Splash damage to " + adjacentShip.getName() + "! Damage: " + SPLASH_DAMAGE);
                    if (adjacentShip.isDestroyed()) {
                        System.out.println(adjacentShip.getName() + " is destroyed!");
                    }
                }
            }
        }
    }
}

