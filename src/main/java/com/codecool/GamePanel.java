package com.codecool;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //SCREEN SETTINGS
    private final int tileSize = 10;
    private final int maxScreenCol = 130;
    private final int maxScreenRow = 70;
    private final int startingNumberOfAliveCells = 2000;
    private final int screenWidth = maxScreenCol * tileSize;
    private final int screenHeight = maxScreenRow * tileSize;

    //FPS
    private final int FPS = 60;

    //SYSTEM
    Thread gameThread;
    Board board = new Board(maxScreenRow,maxScreenCol,this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public void setupGame() {
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
