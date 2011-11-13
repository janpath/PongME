/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.github.janpath.pongME;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

/**
 *
 * @author Max
 */
public class PongSound {

	public javax.microedition.media.Player p;
	private static Hashtable mapSound = new Hashtable();
	private static long timeLastSound = 0;
	private static boolean enabled = true;

	public static javax.microedition.media.Player getPlayer(String sound) {
		javax.microedition.media.Player player;
		player = (javax.microedition.media.Player) mapSound.get(sound);
		if (player == null) {
			try {
				String fileSpec = "/sound/";
				fileSpec += sound;
				InputStream is = PongSound.class.getResourceAsStream(fileSpec);
				if (fileSpec.endsWith("wav")) {
					player = Manager.createPlayer(is, "audio/wav");
				} else if (fileSpec.endsWith("mid")) {
					player = Manager.createPlayer(is, "audio/midi");
				}
				mapSound.put(sound, player);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return player;
	}

	public static void playSound(String sound) {
		if (!enabled) {
			return;
		}
		if (Math.abs(System.currentTimeMillis() - timeLastSound) < 10) {
			System.out.println("tried to play 2 sounds too soon");
			return;
		}
		timeLastSound = System.currentTimeMillis();
		javax.microedition.media.Player player = getPlayer(sound);
		try {
			Enumeration enumValues;
			Player playerOther;
			for (enumValues = mapSound.elements(); enumValues.hasMoreElements();) {
				playerOther = (Player) enumValues.nextElement();
				if (playerOther != player && playerOther.getState() == javax.microedition.media.Player.STARTED) {
					playerOther.deallocate();
				}
			}
			if (player.getState() == javax.microedition.media.Player.STARTED) {
				System.out.println("sound already started");
				return;
			}
			player.start();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void setEnabled(boolean enabled) {
		PongSound.enabled = enabled;
	}
}
