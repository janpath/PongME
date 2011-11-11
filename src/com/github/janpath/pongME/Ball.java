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
    
    
    public Ball(int x, int y, int diameter, Court court) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius   = diameter / 2;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }    

    public void run() {
        
    }
}
