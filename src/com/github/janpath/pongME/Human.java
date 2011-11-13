/*
 * This class will handle a human player
 */
package com.github.janpath.pongME;

/**
 *
 * @author Max
 */
public class Human extends Player implements Runnable {

	private Court court;

	public Human(int x, int y, int width, int height, Court court) {
		super(x, y, width, height);
		this.court = court;
		init();
	}

	public void run() {
		while (true) {
			int keyState = court.getKeyStates();

			if ((keyState & court.LEFT_PRESSED) != 0 && x > -(width / 2)) {
				x -= 3;
			}
			if ((keyState & court.RIGHT_PRESSED) != 0 && x < court.getWidth() - (width / 2)) {
				x += 3;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
