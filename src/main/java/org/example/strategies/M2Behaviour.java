package org.example.strategies;

import org.example.models.Cell;
import org.example.models.Ship;

public class M2Behaviour implements MissileBehavior {
    private static final int DAMAGE = 10;
    private static final int radius = 1;

    @Override
    public void fire(int targetX, int targetY,Cell[][] board) {
        Cell targetCell = board[targetX][targetY];
        Ship targetShip = targetCell.getShip();

        if (targetShip != null) {
            targetShip.takeDamage(DAMAGE);
            System.out.println("Missile M2 hits " + targetShip.getName() + "! Damage: " + DAMAGE);

            if (targetShip.isDestroyed()) {
                System.out.println(targetShip.getName() + " is destroyed!");
            }
            return;
        }

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                int x = targetX + dx;
                int y = targetY + dy;

                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                    Cell cell = board[x][y];
                    Ship ship = cell.getShip();

                    if (ship != null) {
                        ship.takeDamage(DAMAGE);
                        System.out.println("Missile M2 hits " + ship.getName() + "! Damage: " + DAMAGE);

                        if (ship.isDestroyed()) {
                            System.out.println(ship.getName() + " is destroyed!");
                        }
                        return;
                    }
                }
            }
        }
        System.out.println("Missile M2 hits empty cell at (" + targetX + ", " + targetY + ").");
    }

}

