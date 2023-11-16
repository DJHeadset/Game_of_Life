package com.codecool;

import com.codecool.logger.FileLogger;
import com.codecool.logger.Logger;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //SCREEN SETTINGS
    private final int tileSize = 5;
    private final int maxScreenCol = 1500;
    private final int maxScreenRow = 750;
    private final int screenCol = maxScreenCol/tileSize;
    private final int screenRow = maxScreenRow/tileSize;

    //FPS
    int FPS = 30;

    //SYSTEM
    Thread gameThread;
    Board board = new Board(screenRow, screenCol,this);

    public GamePanel() {
        int screenWidth = screenCol * tileSize;
        int screenHeight = screenRow * tileSize;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getScreenCol() {
        return screenCol;
    }

    public int getScreenRow() {
        return screenRow;
    }

    public void setupGame() {
        Logger logger = new FileLogger();
        int startingNumberOfAliveCells = (screenCol * screenRow) / 2;
        logger.ClearFile();
        board.setUpBoard(startingNumberOfAliveCells);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta > 1) {
                update();
                repaint();
                delta--;
            }
            if (timer >= 1000000000) {
                timer = 0;
            }
        }
    }

    public void update() {
        board.updateBoard();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);
        g2.dispose();
    }
}
