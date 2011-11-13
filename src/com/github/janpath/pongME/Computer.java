/*
 * This class will handle a computer player
 */
package com.github.janpath.pongME;

/**
 *
 * @author Max
 */
public class Computer extends Player implements Runnable {
    private Court court;
    private Thread thread;
    private int courtWidth, courtHeight;
    
    public Computer(int x, int y, int width, int height, Court court) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.court = court;
        this.courtWidth  = court.getWidth();
        this.courtHeight = court.getHeight();
                
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        int dir = 1;
        
        while(true) {
            x = court.ball.getX() - (width / 2) + court.ball.radius;
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
