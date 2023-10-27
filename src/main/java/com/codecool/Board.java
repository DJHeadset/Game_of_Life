package com.codecool;

import com.codecool.logger.FileLogger;
import com.codecool.logger.Logger;

import java.awt.*;
import java.util.Random;

public class Board {
    Logger logger = new FileLogger();
    GamePanel gp;
    private final int[][] grid;
    private final int row;
    private final int col;
    private final int size;
    Random random = new Random();

    public Board(int row, int col, GamePanel gp) {
        this.gp = gp;
        grid = new int[row][col];
        this.row = gp.getScreenRow();
        this.col = gp.getScreenCol();
        size = gp.getTileSize();
    }

    public void setUpBoard(int aliveCells) {
        int counter = aliveCells;
        while (counter > 0) {
            int x = random.nextInt(col);
            int y = random.nextInt(row);
            int coordinate = grid[y][x];
            if (coordinate == 0) {
                counter--;
                grid[y][x] = 1;
            }
        }
    }

    public void updateBoard() {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                encodeBoard(grid, x, y);
            }
        }
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                updateCells(grid, x, y);
            }
        }
    }

    private void encodeBoard(int[][] board, int x, int y) {
        int aliveCount = 0;
        for (int i = y - 1; i < y + 2; i++) {
            for (int j = x - 1; j < x + 2; j++) {
                if (i >= 0 && i < board.length
                        && j >= 0 && j < board[i].length) {
                    int neighbour = board[i][j];
                    if (i < y || (i == y && j <= x)) {
                        neighbour = neighbour / 10;
                    }
                    aliveCount += neighbour;
                }
            }
        }
        board[y][x] = 10 * board[y][x] + aliveCount;
    }

    private void updateCells(int[][] board, int x, int y) {
        int neighbour = board[y][x] % 10;
        boolean isAlive = board[y][x] / 10 == 1;

        if (isAlive && (neighbour < 2 || neighbour > 3)) {
            board[y][x] = 0;
        } else if (!isAlive && neighbour == 3) {
            board[y][x] = 1;
        } else board[y][x] = board[y][x] / 10;
    }


    public void draw(Graphics2D g2) {
        int population = 0;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (grid[y][x] == 1) {
                    g2.fillRect(x * size, y * size, size, size);
                    population++;
                }
            }
        }
        logger.LogInfo(population);
    }
}
