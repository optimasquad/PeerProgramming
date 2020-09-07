package com.battleship.game.main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author JATIN MAHAJAN
 *
 */
public class Player {

	private Queue<Missile> missiles = new LinkedList<Missile>();
	private String playerName;
	private BattleArea battleArea;

	public Player(String name) {
		this.playerName = name;
	}

	/**
	 * Read battle area dimensions as input and create battleArea. It throws
	 * InvalidBattleAreaException if the area is not within defined range.
	 * 
	 * @param battleAreaDimensions
	 * @return
	 */
	public BattleArea createPlayerArea(String battleAreaDimensions) {
		String[] dimensions = battleAreaDimensions.split(" ");
		battleArea = new BattleArea(new Integer(dimensions[0]), dimensions[1].charAt(0));
		return battleArea;
	}

	/**
	 * This method is used to calculate the player area
	 * 
	 * @param totalShips
	 */
	public Ship[] calculatePlayerArea(int totalShips) {
		// Add totalShips to each battleArea
		return battleArea.addShipsToBattleArea(1, battleArea.getWidth() * battleArea.getHeight(), totalShips);
	}

	/**
	 * This method is used to land player ships to battle area
	 * 
	 * @param type
	 * @param width
	 * @param height
	 * @param location
	 */
	public Ship landPlayerShips(String type, int width, int height) {
		// Add different type of ships to each battleArea
		Ship ship = new BattleShip(1, battleArea.getWidth(), 'A', battleArea.getHeight());
		return ship.createShip(type, width, height);

	}

	/**
	 * This method is for player to calculate the battleship coordinates
	 * 
	 * @param ship
	 * @param location
	 */
	public void playerBattleshipCoordinates(Ship ship, String location) {
		battleArea.calculateBattleShipCoordinates(ship, location);
	}

	/**
	 * Read missile target location as input for each Player and add those missiles
	 * 
	 * @param missile
	 * @return
	 */
	public void addPlayerMissiles(String missile) {
		for (String target : missile.split(" ")) {
			Missile m = new Missile(target);
			missiles.add(m);
		}
	}

	/**
	 * This method verifies that whether the player hit to target was a miss or a
	 * success
	 */
	public boolean isHitSuccess(Player player) {
		boolean hit = false;
		Missile missile = missiles.remove();
		int value = player.getBattleArea().getArea()[missile.getRow()][missile.getColumn()];
		if (value == 0) {
			System.out.println(playerName + " fires a missile with target " + missile.getTarget() + " which got miss");
		} else {
			System.out.println(playerName + " fires a missile with target " + missile.getTarget() + " which got hit");
			player.getBattleArea().getArea()[missile.getRow()][missile
					.getColumn()] = player.getBattleArea().getArea()[missile.getRow()][missile.getColumn()] - 1;
			player.getBattleArea().reduceTotalStrength();
			hit = true;
		}
		return hit;
	}

	public boolean isOut() {
		return (battleArea.getTotalStrength() == 0) ? true : false;
	}

	public Queue<Missile> getMissiles() {
		return missiles;
	}

	public String getPlayerName() {
		return playerName;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}
}
