/*
 * This class is the base class for players
 */
package com.github.janpath.pongME;

/**
 *
 * @author Max
 */
public class Player extends Paddle implements Runnable {
	public int score = 0;
	private Thread thread;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void init() {
		thread = new Thread(this);
		thread.start();
	}

	public void run() {

	}
}
