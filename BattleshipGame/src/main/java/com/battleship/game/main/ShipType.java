package com.battleship.game.main;

public enum ShipType {

	P(1), Q(2);

	private final int strength;

	ShipType(int strength) {
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}
}
