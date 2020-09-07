
package com.battleship.game.main;

import java.util.List;

import com.battleship.game.util.FileIOUtil;

/**
 * @author JATIN MAHAJAN
 *
 */
public class BattleShipGame {

	Player player1, player2;

	public static void main(String[] args) {

		System.out.println("Welcome to Battle Ship! Initiating the game!");
		List<String> input = FileIOUtil.readFile("input.txt");

		BattleShipGame game = new BattleShipGame();
		game.startGame(input);
	}

	public void startGame(List<String> input) {
		player1 = new Player("Player-1");
		player2 = new Player("Player-2");

		// creating Player 1 and Player 2 Battle Area
		player1.createPlayerArea(input.get(0));
		player2.createPlayerArea(input.get(0));

		// adding missiles to player
		player1.addPlayerMissiles(input.get(input.size() - 2));
		player2.addPlayerMissiles(input.get(input.size() - 1));

		// Read totalships and ship coordinates as input and place ships on each
		// Player's battleArea at the respective coordinates
		int totalShips = new Integer(input.get(1));
		player1.calculatePlayerArea(totalShips);
		player2.calculatePlayerArea(totalShips);

		// Add different type of ships to each battleArea
		for (int i = 0; i < totalShips; i++) {
			String[] battleShipDetail = input.get(i + 2).split(" ");
			Ship ship =player1.landPlayerShips(battleShipDetail[0], new Integer(battleShipDetail[1]),
					new Integer(battleShipDetail[2]));
			
			player1.playerBattleshipCoordinates(ship,battleShipDetail[3]);
			
			Ship ship2=player2.landPlayerShips(battleShipDetail[0], new Integer(battleShipDetail[1]),
					new Integer(battleShipDetail[2]));
			
			player2.playerBattleshipCoordinates(ship2,battleShipDetail[4]);
		}
		// PlayGame
		play();
	}

	private void play() {
		boolean win = false;
		while (!win) {
			if (isSuccessShoot(player1, player2)) {
				break;
			} else if (isSuccessShoot(player2, player1)) {
				break;
			}

		}
	}

	private boolean isSuccessShoot(Player player1, Player player2) {
		boolean win = false;
		if (player1.getMissiles().size() == 0) {
			System.out.println(player1.getPlayerName() + " has no more missiles left to launch");
		} else {
			boolean hit = true;
			while (hit && player1.getMissiles().size() > 0) {
				hit = player1.isHitSuccess(player2);
				if (player2.isOut()) {
					System.out.println(player1.getPlayerName() + " won the battle");
					win = true;
					break;
				}
			}
		}
		return win;
	}

}
