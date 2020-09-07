package com.battleship.game.main;

import com.battleship.game.exception.InvalidBattleAreaException;
import com.battleship.game.exception.InvalidShipCoordinatesException;
import com.battleship.game.exception.InvalidShipCountException;
import com.battleship.game.util.BattleshipConstants;

/**
 * @author JATIN MAHAJAN
 *
 */
public class BattleArea {

	private int width;
	private char height;
	private int area[][];
	private Ship[] ship;
	private int nextShipPosition = 0;
	private int totalStrength = 0;

	public BattleArea(int width, char height) {
		this.width = width;
		this.height = height;
		if (width < BattleshipConstants.MIN_WIDTH || width > BattleshipConstants.MAX_WIDTH) {
			throw new InvalidBattleAreaException(
					"Invalid Battle Area Size: width[" + width + "], " + " Width must be between(inclusive) "
							+ BattleshipConstants.MIN_WIDTH + " and " + BattleshipConstants.MAX_WIDTH);
		}
		if (height < BattleshipConstants.MIN_HEIGHT || height > BattleshipConstants.MAX_HEIGHT) {
			throw new InvalidBattleAreaException(
					"Invalid Battle Area Size: height[" + height + "]. Height must be between(inclusive) "
							+ BattleshipConstants.MIN_HEIGHT + " and " + BattleshipConstants.MAX_HEIGHT);
		}
		this.area = new int[height - 64][width];
	}

	/**
	 * This method is used to add the ships to the battle area on basis of min,max
	 * and total ships to be added
	 * 
	 * @param minShip
	 * @param maxShip
	 * @param totalShips
	 * @return
	 */
	public Ship[] addShipsToBattleArea(int minShip, int maxShip, int totalShips) {
		if (totalShips < minShip || totalShips > maxShip) {
			throw new InvalidShipCountException(
					"Invalid Ship Count: " + totalShips + "Must be between(inclusive) " + minShip + " and " + maxShip);
		}
		this.ship = new Ship[totalShips];
		return this.ship;
	}

	/**
	 * This method is used to calculate the battleship coordinates on basis of the
	 * ship coordinates and its location
	 * 
	 * @param ship
	 * @param location
	 */
	public void calculateBattleShipCoordinates(Ship ship, String location) {
		this.ship[nextShipPosition++] = ship;
		char yCoord = location.charAt(0);
		int xCoord = Integer.parseInt(location.substring(1));
		if (xCoord < ship.getMinWidth() || xCoord > ship.getMaxWidth()) {
			throw new InvalidShipCoordinatesException("Invalid Ship Corridinate : x[" + xCoord + "], "
					+ " X Coordinate must be between(inclusive) " + ship.getMinWidth() + " and " + ship.getMaxWidth());
		}
		if (yCoord < ship.getMinHeight() || yCoord > ship.getMaxHeight()) {
			throw new InvalidShipCoordinatesException(
					"Invalid Ship Corridinate : y[" + yCoord + "], " + " Y Coordinate must be between(inclusive) "
							+ ship.getMinHeight() + " and " + ship.getMaxHeight());
		}

		for (int i = yCoord - 65; i < yCoord - 65 + ship.getHeight(); i++) {
			for (int j = xCoord - 1; j < xCoord - 1 + ship.getWidth(); j++) {
				area[i][j] = ship.getStrength(ship.getType());
				totalStrength += area[i][j];
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public char getHeight() {
		return height;
	}

	public int[][] getArea() {
		return area;
	}

	public int reduceTotalStrength() {
		return --totalStrength;
	}

	public int getTotalStrength() {
		return totalStrength;
	}

}
