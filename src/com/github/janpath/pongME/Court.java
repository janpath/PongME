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
    public int speed = 40;
    public Graphics g;
    private Thread thread;
    private int lastWidth, lastHeight;
    private Font font;

    public Court(MIDlet aMIDlet) {
        super(aMIDlet);
        g = getGraphics();
        
        int paddleWidth = getWidth() / 4;
        lastWidth = getWidth();
        lastHeight = getHeight();

        ball = new Ball((getWidth() / 2) - 3, (getHeight() / 2) - 3, 6, this);
        player1 = new Computer((getWidth() / 2) - (paddleWidth / 2), getHeight() - 11, paddleWidth, 6, this);
        player2 = new Computer((getWidth() / 2) - (paddleWidth / 2), 5, paddleWidth, 6, this);
        
        font = Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        g.setFont(font);
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void updateScreen(Graphics g) {
        super.updateScreen(g);
        if (lastHeight != getHeight()) {
            player1.setX((getWidth() / 2) - (player2.width / 2));
            player2.setX((getWidth() / 2) - (player1.width / 2));
            ball.updateOrientation();
        }
        if (lastWidth != getWidth()) {
            ball.updateOrientation();
            player1.setY(getHeight() - 11);
            player2.setY(5);
        }
        lastHeight = getHeight();
        lastWidth = getWidth();
        
        g.setColor(255, 255, 255);
        g.drawString(player1.score + " : " + player2.score, getWidth() / 2, (getHeight() / 2) - 20, g.TOP | g.HCENTER);
        
        g.setStrokeStyle(Graphics.DOTTED);
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        g.setStrokeStyle(Graphics.SOLID);

        g.setColor(60, 140, 255);
        g.fillRect(player1.x, player1.y, player1.width, player1.height);

        g.setColor(200, 30, 55);
        g.fillRect(player2.x, player2.y, player2.width, player2.height);

        g.setColor(255, 255, 255);
        g.fillArc(ball.getX(), ball.getY(), ball.diameter, ball.diameter, 0, 360);

        flushGraphics();
    }

    public void run() {
        int delay = FPS.getDelayFromFPS(30);

        while (true) {
            updateScreen(g);
            FPS.enforceCycleDelay(delay);
        }
    }
}
