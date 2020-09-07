package com.battleship.game.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.battleship.game.exception.InvalidBattleAreaException;
import com.battleship.game.exception.InvalidShipCoordinatesException;
import com.battleship.game.exception.InvalidShipCountException;

public class BattleAreaTest {

	@Test(expected = InvalidBattleAreaException.class)
	public void testThowExceptionWhenWidthLessThanMinimumBattleAreaWidth() {
		int width = 0;
		new BattleArea(width, 'Z');
	}

	@Test(expected = InvalidBattleAreaException.class)
	public void tesThrowExceptionWhenWidthGreaterThanMaximumBattleAreaWidth() {
		int width = 10;
		new BattleArea(width, 'Z');
	}

	@Test(expected = InvalidBattleAreaException.class)
	public void tesThrowExceptionWhenHeightLessThanMinimumBattleAreaHeight() {
		char height = '@';
		new BattleArea(5, height);
	}

	@Test(expected = InvalidBattleAreaException.class)
	public void testThrowExceptioWhenHeightGreaterThanMaximumBattleAreaHeight() {
		char height = '[';
		new BattleArea(5, height);
	}

	@Test
	public void testSetBattleAreaWidthAndHeightWhenCreatingBattleArea() {
		BattleArea battleArea = new BattleArea(5, 'Z');
		int size[][] = battleArea.getArea();
		int rows = size.length;
		int cols = size[0].length;
		assertArrayEquals(new int[] { 26, 5 }, new int[] { rows, cols });
		assertArrayEquals(new int[] { 26, 5 },
				new int[] { battleArea.getArea().length, battleArea.getArea()[0].length });
	}

	@Test(expected = InvalidShipCountException.class)
	public void testThrowExceptionWhenTotalBattleShipsNotWithinDefinedRange() {
		int min = 1, max = 10;
		BattleArea battleArea = new BattleArea(5, 'Z');
		battleArea.addShipsToBattleArea(min, max, 11);
	}

	@Test
	public void testAddTotalBattleShipsWhenAddShip() {
		int min = 1, max = 10;
		BattleArea battleArea = new BattleArea(5, 'Z');
		Ship[] ship = battleArea.addShipsToBattleArea(min, max, 5);
		assertEquals(5, ship.length);
	}

	@Test
	public void tesSetShipLocationAndPowerWhenAddShip() {
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addShipsToBattleArea(1, 9, 1);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		ship = ship.createShip("Q", 1, 1);
		battleArea.calculateBattleShipCoordinates(ship, "B2");

		for (int i = 0; i < battleArea.getArea().length; i++) {
			for (int j = 0; j < battleArea.getArea()[i].length; j++) {
				if (i == 1 && j == 1) {
					assertEquals(2, battleArea.getArea()[i][j]);
				} else {
					assertEquals(0, battleArea.getArea()[i][j]);
				}
			}
		}
	}

	@Test(expected = InvalidShipCoordinatesException.class)
	public void testThrowExceptionWhenShipXCoordinateLessThanBattleAreaWidth() {
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addShipsToBattleArea(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.calculateBattleShipCoordinates(ship, "@1");
	}

	@Test(expected = InvalidShipCoordinatesException.class)
	public void testThrowExceptionWhenShipXCoordinateGreaterThanBattleAreaWidth() {
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addShipsToBattleArea(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.calculateBattleShipCoordinates(ship, "[1");
	}

	@Test(expected = InvalidShipCoordinatesException.class)
	public void testThrowExceptionWhenShipYCoordinateLessThanBattleAreaHeight() {
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addShipsToBattleArea(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.calculateBattleShipCoordinates(ship, "A0");
	}

	@Test(expected = InvalidShipCoordinatesException.class)
	public void testThrowExceptionWhenShipYCoordinateGreaterThanBattleAreaHeight() {
		BattleArea battleArea = new BattleArea(5, 'E');
		battleArea.addShipsToBattleArea(1, 9, 5);
		Ship ship = new BattleShip(1, 9, 'A', 'Z');
		battleArea.calculateBattleShipCoordinates(ship, "A10");
	}

	@Test
	public void testSetWidth_When_DrawArea() {
		int width = 5;
		BattleArea battleArea = new BattleArea(width, 'E');
		assertEquals(width, battleArea.getWidth());
	}

	@Test
	public void testSetHeightWhenDrawArea() {
		char height = 'E';
		BattleArea battleArea = new BattleArea(5, height);
		assertEquals(height, battleArea.getHeight());
	}

}
