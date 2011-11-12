/*
 * This class will handle the ball
 */
package com.github.janpath.pongME;

/**
 *
 * @author Max
 */
public class Ball implements Runnable {
    private int x;
    private int y;
    private int speed;
    public int directionX;
    public int directionY;
    public int diameter;
    public int radius;
    private Thread thread;
    private final int courtWidth;
    private final int courtHeight;
    
    public Ball(int x, int y, int diameter, Court court) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius   = diameter / 2;
        this.courtWidth  = court.getWidth();
        this.courtHeight = court.getHeight();
        this.speed = court.speed;
        
        thread = new Thread(this);
        thread.start();
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }    

    public void setSpeed(int speed) {
        System.out.println(speed);
        this.speed = speed;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void run() {
        int dirX = 1, dirY = 1;
        
        while(true) {
            if(x > courtWidth  - diameter) {
                dirX = -1;
                PongSound.playSound("pongWall.wav");
            }
            if(x < 1) {
                dirX = 1;
                PongSound.playSound("pongWall.wav");
            }
            
            if(y > courtHeight  - diameter) {
                dirY = -1;
                PongSound.playSound("pongWall.wav");
            }
            if(y < 1) {
                dirY = 1;
                PongSound.playSound("pongWall.wav");
            }
            
            if(dirX == 1) ++x;
            else if(dirX == -1) --x;
            
            if(dirY == 1) ++y;
            else if(dirY == -1) --y;
            
            try {
                Thread.sleep(51 - speed);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }        
    }
}
