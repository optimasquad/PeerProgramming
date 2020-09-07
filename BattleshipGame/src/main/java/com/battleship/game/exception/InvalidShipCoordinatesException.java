package com.battleship.game.exception;

public class InvalidShipCoordinatesException extends RuntimeException {

	private static final long serialVersionUID = -4737858985380728680L;

	public InvalidShipCoordinatesException(String s) {
		super(s);
	}
}
