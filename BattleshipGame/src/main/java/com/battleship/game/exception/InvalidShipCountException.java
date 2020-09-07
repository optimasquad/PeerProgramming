package com.battleship.game.exception;

public class InvalidShipCountException extends RuntimeException {

	private static final long serialVersionUID = -4737858985380728680L;

	public InvalidShipCountException(String s) {
		super(s);
	}
}
