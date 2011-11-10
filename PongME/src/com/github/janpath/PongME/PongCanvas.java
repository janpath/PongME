package com.github.janpath.PongME;

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author Max
 */
public class PongCanvas extends GameCanvas implements Runnable {

	private boolean menuFinished = false;

	public PongCanvas(MIDlet aMIDlet) {
		super(true);
		init();
	}

	private void init() {
		Thread runner = new Thread(this);
		runner.start();
	}

	public void update(int state) {
	}

	public void render(Graphics g) {
		//g.setColor(0);
		//g.fillRect(0, 0, getWidth(), getHeight());
		
		if (!menuFinished) {
			g.setColor(0);
			g.fillRect(0, 0, getWidth(), getHeight());

			for (int i = -40; i < 20; ++i) {
				int x = (getWidth() / 2) - (115 / 2);
				
				//reset screen
				g.setColor(0);
				g.fillRect(0, 0, getWidth(), getHeight());
				//
				
				g.setColor(255, 255, 255);
				g.fillRect(x, i, 5, 35);
				g.fillRect(5 + x, i, 15, 5);
				g.fillRect(20 + x, i, 5, 20);
				g.fillRect(5 + x, 15 + i, 15, 5);

				g.fillRect(30 + x, i, 5, 35);
				g.fillRect(35 + x, i, 15, 5);
				g.fillRect(50 + x, i, 5, 35);
				g.fillRect(35 + x, 30 + i, 15, 5);

				g.fillRect(60 + x, i, 5, 35);
				for (int j = 0; j < 7; ++j) {
					g.drawLine(65 + x, i + j, 79 + x, 28 + j + i);
				}
				g.fillRect(80 + x, i, 5, 35);

				g.fillRect(90 + x, i, 5, 35);
				g.fillRect(95 + x, i, 20, 5);
				g.fillRect(110 + x, 15 + i, 5, 20);
				g.fillRect(95 + x, 30 + i, 15, 5);
				g.fillRect(105 + x, 15 + i, 5, 5);

				flushGraphics();
				try {
					Thread.sleep(20);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
					//}
				}
			}
			menuFinished = true;
		}
	}

	public void run() {
		Graphics g = getGraphics();
		while (true) {
			update(getKeyStates());
			render(g);
			flushGraphics();
			try {
				//let the CPU rest a bit.
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}