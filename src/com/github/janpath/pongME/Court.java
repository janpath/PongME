/*
 * This class will handle the pong court
 */
package com.github.janpath.pongME;

import java.util.Random;
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
    public int speed = 45;
    public int sleepTime = 30;
    private int j;
    
    public Court(MIDlet aMIDlet) {
        super(aMIDlet);
        ball    = new     Ball((getWidth() / 2) - 3, (getHeight() / 2) - 3, 6, this);
        player1 = new Computer((getWidth() / 2) - 20, 5, 40, 5, this);
        player2 = new Computer((getWidth() / 2) - 20, getHeight() - 10, 40, 5, this);
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void updateScreen(Graphics g) {
        super.updateScreen(g);        
        g.setColor(255, 255, 255);
        g.setStrokeStyle(Graphics.DOTTED);
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        g.setStrokeStyle(Graphics.SOLID);
        g.fillRect(player1.x, player1.y, player1.width, player1.height);
        g.fillRect(player2.x, player2.y, player2.width, player2.height);
        
        g.setColor(255, 0, 0);
        g.fillArc(ball.getX(), ball.getY(), ball.diameter, ball.diameter, 0, 360);
        
        flushGraphics();
    }

    public void run() {
        Graphics g = getGraphics();
        
        while (true) {
            updateScreen(g);
            try {
                Thread.sleep(sleepTime); 
            } catch (Exception e) {}
        }
    }
}
