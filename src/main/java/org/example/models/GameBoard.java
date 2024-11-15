package org.example.models;

public class GameBoard {
    private int width;
    private int height;
    private Cell[][] board;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new Cell[width][height];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
