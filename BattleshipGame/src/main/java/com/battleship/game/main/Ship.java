package com.battleship.game.main;

/**
 * Generic class to represent any type of Ship
 * 
 * @author JATIN MAHAJAN
 */
public abstract class Ship {

	protected int minWidth;
	protected int maxWidth;
	protected char minHeight;
	protected char maxHeight;

	protected int width;
	protected int height;
	protected String type;

	/**
	 * This method is used to create the ship on basis of the input ship type and
	 * ship height and width
	 * 
	 * @param type
	 * @param width
	 * @param height
	 * @return
	 */
	public abstract Ship createShip(String type, int width, int height);

	/**
	 * This method is used to extract the strength of ship required to destroy
	 * it.e.g P requires 1 and Q requires 2 missiles to destroy it.
	 * 
	 * @param type
	 * @return
	 */
	public abstract int getStrength(String type);

	public int getMinWidth() {
		return minWidth;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public char getMinHeight() {
		return minHeight;
	}

	public char getMaxHeight() {
		return maxHeight;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}

}
