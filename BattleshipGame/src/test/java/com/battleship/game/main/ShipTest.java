package com.battleship.game.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.battleship.game.exception.InvalidShipDimensionsException;
import com.battleship.game.exception.InvalidShipTypeException;

/**
 * 
 * @author JATIN MAHAJAN
 *
 */
public class ShipTest {

	Ship ship = new BattleShip(1, 9, 'A', 'Z');

	@Test
	public void testSetMinWidthWhenCreateShipObject() {
		assertEquals(1, ship.getMinWidth());
	}

	@Test
	public void testSetMaxWidthWhenCreateShipObject() {
		assertEquals(9, ship.getMaxWidth());
	}

	@Test
	public void testSetMinHeightWhenCreateShipObject() {
		assertEquals('A', ship.getMinHeight());
	}

	@Test
	public void testSetMaxHeightWhenCreateShipObject() {
		assertEquals('Z', ship.getMaxHeight());
	}

	@Test
	public void testSetWidthWhenCreateShip() {
		int width = 3;
		ship.createShip("P", width, 4);
		assertEquals(width, ship.getWidth());
	}

	@Test
	public void testSetHeightWhenCreateShip() {
		int height = 4;
		ship.createShip("P", 3, height);
		assertEquals(height, ship.getHeight());
	}

	@Test
	public void testSetShipTypeWhenCreateShip() {
		String type = "P";
		ship.createShip(type, 3, 4);
		assertEquals(type, ship.getType());
	}

	@Test(expected = InvalidShipDimensionsException.class)
	public void testThrowExceptionWhenWidthLessThanDefinedRange() {
		int width = 0;
		ship.createShip("P", width, 4);
	}

	@Test(expected = InvalidShipDimensionsException.class)
	public void testThrowExceptionWhenWidthGreaterThanDefinedRange() {
		int width = 10;
		ship.createShip("P", width, 4);
	}

	@Test(expected = InvalidShipTypeException.class)
	public void testThrowExceptionWhenShipTypeOtherThanDefineType() {
		String type = "Z";
		ship.createShip(type, 9, 4);
	}

	@Test(expected = InvalidShipDimensionsException.class)
	public void testThrowExceptionWhenHeightLessThanDefinedRange() {
		int height = 0;
		ship.createShip("P", 4, height);
	}

	@Test(expected = InvalidShipDimensionsException.class)
	public void testThrowExceptionWhenHeightGreaterThanDefinedRange() {
		int height = 27;
		ship.createShip("P", 4, height);
	}

	@Test
	public void testReturnPowerWhenGetPower() {
		assertArrayEquals(new int[] { 1, 2 },
				new int[] { ship.getStrength(ShipType.P.name()), ship.getStrength(ShipType.Q.name()) });
	}

}
