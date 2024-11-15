package org.example;

import org.example.models.*;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        Cell[][] board = gameManager.getGameBoard().getBoard();

        //Ship A is of 2x2 dimensions
        //Ship B is of 1x2 dimensions
        //todo-this is a hardcoded placement of ships, this can be made dynamic
        Ship player1shipA = new ShipA();
        board[0][0].placeShip(player1shipA);
        board[0][1].placeShip(player1shipA);
        board[1][0].placeShip(player1shipA);
        board[1][1].placeShip(player1shipA);

        Ship player2shipB = new ShipB();
        board[2][0].placeShip(player2shipB);
        board[2][1].placeShip(player2shipB);

        for (int i = 0; i < 5; i++) {
            player1shipA.addMissile(new MissileM1());
        }
        for (int i = 0; i < 10; i++) {
            player1shipA.addMissile(new MissileM2());
        }

        for (int i = 0; i < 10; i++) {
            player2shipB.addMissile(new MissileM3());
        }

        Player player1 = new Player("Player 1");
        player1.addShip(player1shipA);

        Player player2 = new Player("Player 2");
        player2.addShip(player2shipB);

        gameManager.initializePlayers(player1, player2);

        gameManager.startGame();
    }
}
