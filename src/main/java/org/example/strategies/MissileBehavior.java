package org.example.strategies;

import org.example.models.Cell;
import org.example.models.Coordinate;
import org.example.models.GameBoard;
import org.example.models.Player;

public interface MissileBehavior {
    void fire(int targetX, int targetY, Cell[][] board);
}
