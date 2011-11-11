/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.github.janpath.PongME;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Max
 */
public class PongME extends MIDlet {

	public Display display;
	public PongCanvas canvas = null;

	public void startApp() {
		if (canvas == null) {
			canvas = new PongCanvas(this);
		}
		Display display = Display.getDisplay(this);
		display.setCurrent(canvas);
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unconditional) {
	}
}
