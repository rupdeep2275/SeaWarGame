package org.example.models;

public class GameManager {
    private final GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private boolean gameRunning;
    private Player currentPlayer;

    private GameManager() {
        this.gameBoard = new GameBoard(16, 8);
    }

    private static class LazyLoader {
        private static final GameManager INSTANCE = new GameManager();
    }

    public static GameManager getInstance() {
        return LazyLoader.INSTANCE;
    }

    public void initializePlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void startGame() {
        if (player1 == null || player2 == null) {
            throw new IllegalStateException("Players must be initialized before starting the game.");
        }

        this.gameRunning = true;
        System.out.println("Game started!");

        while (gameRunning) {
            System.out.println("\n" + currentPlayer.getName() + "'s turn:");
            takeTurn(currentPlayer);
            if (checkGameOver()) {
                gameRunning = false;
                System.out.println("Game Over!");
                Player winner = determineWinner();
                if (winner != null) {
                    System.out.println("Winner: " + winner.getName());
                } else {
                    System.out.println("It's a draw!");
                }
                break;
            }
            switchTurns();
        }
    }

    private void takeTurn(Player player) {
        System.out.println("Choose an action: (1) Fire missile, (2) Move ship");
        handleFireAction(player);
    }

    private void handleFireAction(Player player) {
        Missile missile = player.chooseMissile();
        if (missile == null) {
            System.out.println("No missile selected. Turn skipped.");
            return;
        }

        //choose target randomly
        //todo: targetChoosingStrategy can be used here
        int targetX = (int) (Math.random() * 3);
        int targetY = (int) (Math.random() * 3);

        missile.executeBehavior(targetX, targetY, gameBoard.getBoard());
    }

    private void switchTurns() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean checkGameOver() {
        boolean plsyer1MissilesLeft = player1.hasMissileLeft();
        boolean player2MissilesLeft = player2.hasMissileLeft();
        if(!plsyer1MissilesLeft && !player2MissilesLeft) {
            return true;
        }
        boolean player1ShipsAlive = player1.hasShipsLeft();
        boolean player2ShipsAlive = player2.hasShipsLeft();
        return !(player1ShipsAlive && player2ShipsAlive);
    }

    private Player determineWinner() {
        boolean player1ShipsAlive = player1.hasShipsLeft();
        boolean player2ShipsAlive = player2.hasShipsLeft();

        if (player1ShipsAlive && !player2ShipsAlive) {
            return player1;
        } else if (!player1ShipsAlive && player2ShipsAlive) {
            return player2;
        } else {
            return null; //draw
        }
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}

