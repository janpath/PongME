/*
 * this class will handle the paddles
 */
package com.github.janpath.pongME;

import javax.microedition.lcdui.Graphics;

/**
 *
 * @author Max
 */
public class Paddle {
    protected int x = 0;
    protected int y = 0;
    protected int width;
    protected int height;
    
    
    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getY() {
        return y;
    }
}
