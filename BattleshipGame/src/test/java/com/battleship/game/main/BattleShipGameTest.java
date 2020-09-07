package com.battleship.game.main;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.battleship.game.util.FileIOUtil;

/**
 * @author JATIN MAHAJAN
 *
 */
public class BattleShipGameTest {

	private static BattleShipGame game;
	private static List<String> input_player2;
	private static List<String> input_player1;

	@BeforeClass
	public static void setup() {
		input_player1 = FileIOUtil.readFile("test-input-player1.txt");
		input_player2 = FileIOUtil.readFile("test-input-player2.txt");
		game = new BattleShipGame();
	}

	@Test
	public void testPlayer1WinWhenPlay() {
		game.startGame(input_player1);
		assertTrue(game.player2.isOut());
	}

	@Test
	public void testPlayer2WinWhenPlay() {
		game.startGame(input_player2);
		assertTrue(game.player1.isOut());
	}

}
