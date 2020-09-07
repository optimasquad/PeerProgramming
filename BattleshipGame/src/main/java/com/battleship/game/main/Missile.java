package com.battleship.game.main;

/**
 * @author JATIN MAHAJAN
 *
 */
public class Missile {

	private int row;
	private int column;
	private String target;

	public Missile(String target) {
		this.row = target.charAt(0) - 65;
		this.column = new Integer(target.substring(1)) - 1;
		this.target = target;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	@Override
	public String toString() {
		return target;
	}

}
