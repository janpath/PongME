/*
 * This class is the base class for players
 */
package com.github.janpath.pongME;

/**
 *
 * @author Max
 */
public class Player extends Paddle {

	public int score = 0;

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
}
