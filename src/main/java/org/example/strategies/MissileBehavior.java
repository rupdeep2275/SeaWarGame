package org.example.strategies;

import org.example.models.Cell;

public interface MissileBehavior {
    void fire(int targetX, int targetY, Cell[][] board);
}
