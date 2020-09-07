package com.battleship.game.main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author JATIN MAHAJAN
 *
 */
public class PlayerTest {

	@Test
	public void testReturnPlayerNameWhenConstructPlayerObject() {
		Player player = new Player("Player");
		assertEquals("Player", player.getPlayerName());
	}

	@Test
	public void testReturnAddedMissilesForAddMissile() {
		Player player = new Player("Player");
		player.addPlayerMissiles("A1");
		assertEquals("A1", player.getMissiles().peek().getTarget());
	}

	@Test
	public void testHitIsSuccess() {
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		player1.addPlayerMissiles("A1");
		initBattleAreaData(player2);
		assertTrue(player1.isHitSuccess(player2));
	}

	@Test
	public void testIsHitFails() {
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		player1.addPlayerMissiles("A2");
		initBattleAreaData(player2);
		assertFalse(player1.isHitSuccess(player2));
	}

	@Test
	public void testPlayerIsOut() {
		Player player = new Player("Player");
		player.createPlayerArea("5 E");
		player.calculatePlayerArea(1);
		assertTrue(player.isOut());
	}

	@Test
	public void testPlayerIsNotOut() {
		Player player = new Player("Player");
		player.createPlayerArea("5 E");
		player.calculatePlayerArea(1);
		Ship ship = player.landPlayerShips("P", 1, 1);
		player.playerBattleshipCoordinates(ship, "A1");
		assertFalse(player.isOut());
	}

	@Test
	public void testCreateBattleArea() {
		String battleAreaDimensions = "5 Z";
		Player player = new Player("Player");
		BattleArea battleArea = player.createPlayerArea(battleAreaDimensions);
		assertArrayEquals(new int[] { 26, 5 },
				new int[] { battleArea.getArea().length, battleArea.getArea()[0].length });
	}

	@Test
	public void testAddTotalShipsBattleArea() {
		Player player = new Player("Player");
		player.createPlayerArea("5 E");
		Ship[] ship = player.calculatePlayerArea(5);
		assertEquals(5, ship.length);
	}

	@Test
	public void testAddShipsToBattleArea() {
		String battleAreaDimensions = "6 F";
		Player player = new Player("Player");
		BattleArea battleArea = player.createPlayerArea(battleAreaDimensions);
		player.calculatePlayerArea(5);
		Ship ship = player.landPlayerShips("Q", 2, 2);
		player.playerBattleshipCoordinates(ship, "A4");
		int playerAArea[][] = battleArea.getArea();
		assertArrayEquals(new int[] { 2, 2, 2, 2 },
				new int[] { playerAArea[0][3], playerAArea[0][4], playerAArea[1][3], playerAArea[1][4] });
	}

	private BattleArea initBattleAreaData(Player player) {
		BattleArea battleArea = player.createPlayerArea("2 B");
		battleArea.addShipsToBattleArea(1, 2, 1);
		Ship ship = new BattleShip(1, 2, 'A', 'B');
		ship.createShip("P", 1, 1);
		battleArea.calculateBattleShipCoordinates(ship, "A1");
		return battleArea;
	}
}
