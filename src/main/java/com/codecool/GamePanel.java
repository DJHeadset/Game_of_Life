package com.codecool;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //SCREEN SETTINGS
    private final int tileSize = 10;
    private final int maxScreenCol = 1500/tileSize;
    private final int maxScreenRow = 750/tileSize;

    //SYSTEM
    Thread gameThread;
    Board board = new Board(maxScreenRow,maxScreenCol,this);

    public GamePanel() {
        int screenWidth = maxScreenCol * tileSize;
        int screenHeight = maxScreenRow * tileSize;
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
        int startingNumberOfAliveCells = (maxScreenCol * maxScreenRow) / 2;
        board.setUpBoard(startingNumberOfAliveCells);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //FPS
        int FPS = 30;
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
