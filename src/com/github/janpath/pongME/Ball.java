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
    private int courtWidth;
    private int courtHeight;
    private Court court;

    public Ball(int x, int y, int diameter, Court court) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius = diameter / 2;
        this.court = court;
        this.courtWidth = court.getWidth();
        this.courtHeight = court.getHeight();
        this.speed = court.speed;

        thread = new Thread(this);
        thread.start();
    }

    public void updateOrientation() {
        courtWidth = court.getWidth();
        courtHeight = court.getHeight();
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

    public void reset() {
        x = courtWidth / 2;
        y = courtHeight / 2;
    }
    
    public void run() {
        int dirX = 1, dirY = 1;
        int speedLoop = 0;
        
        while (true) {
            if(speedLoop == 100) {
                speed -= 1;
                speedLoop = 0;
            }
            
            if (x > courtWidth - diameter) {
                dirX = -1;
                PongSound.playSound("pongWall.wav");
            }
            if (x < 1) {
                dirX = 1;
                PongSound.playSound("pongWall.wav");
            }
            
            if((y == court.player1.y - diameter) &&
                    (x >= court.player1.x) &&
                        (x <= court.player1.x + court.player1.width)) {
                            PongSound.playSound("pongPaddle.wav");
                            speed = 45;
                            dirX *= -1;
                            dirY *= -1;
            }
            
            if((y == court.player2.y + diameter) &&
                    (x >= court.player2.x) &&
                        (x <= court.player2.x + court.player2.width)) {
                            PongSound.playSound("pongPaddle.wav");
                            speed = 45;
                            dirX *= -1;
                            dirY *= -1;
            }
            
            if (y > courtHeight - diameter) {
                ++court.player2.score;
                PongSound.playSound("pongPoint.wav");
                reset();
                dirY = 1;
            }
            if (y < 1) {
                ++court.player1.score;
                PongSound.playSound("pongPoint.wav");
                reset();
                dirY = -1;
            }
            
            if (dirX == 1) {
                ++x;
            } else if (dirX == -1) {
                --x;
            }

            if (dirY == 1) {
                ++y;
            } else if (dirY == -1) {
                --y;
            }

            try {
                Thread.sleep(51 - speed);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            ++speedLoop;
        }
    }
}
