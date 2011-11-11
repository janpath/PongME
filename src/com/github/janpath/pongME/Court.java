/*
 * This class will handle the pong court
 */
package com.github.janpath.pongME;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author Max
 */
public class Court extends PongCanvas implements Runnable {
    public Ball ball;
    public Player player1;
    public Player player2;
    private Thread thread;
    
    public int speed = 10;
    
    public Court(MIDlet aMIDlet) {
        super(aMIDlet);
        ball    = new Ball((getWidth() / 2) - 3, (getHeight() / 2) - 3, 6, this);
        player1 = new    Human((getWidth() / 2) - 20, 5,               40, 5);
        player2 = new Computer((getWidth() / 2) - 20, getHeight() - 10, 40, 5);
    }
    
    public void paint(Graphics g) {
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, getHeight(), getWidth());
        
        g.setColor(255, 255, 255);
        g.setStrokeStyle(Graphics.DOTTED);
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        g.setStrokeStyle(Graphics.SOLID);
        g.fillRect(player1.x, player1.y, player1.width, player1.height);
        g.fillRect(player2.x, player2.y, player2.width, player2.height);
        g.fillArc(ball.getX(), ball.getY(), ball.diameter, ball.diameter, 0, 360);
    }
    
    public void run() {

    }
    
}
