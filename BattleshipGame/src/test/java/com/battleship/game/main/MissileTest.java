package com.battleship.game.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author JATIN MAHAJAN
 *
 */
public class MissileTest {

	@Test
	public void testSetRowWhenMissileObjectIsCreated() {
		Missile m = new Missile("A10");
		assertEquals(0, m.getRow());
	}

	@Test
	public void testSetColumnWhenMissileObjectIsCreated() {
		Missile m = new Missile("A10");
		assertEquals(9, m.getColumn());
	}

	@Test
	public void testSetTargetWhenMissileObjectIsCreated() {
		Missile m = new Missile("A10");
		assertEquals("A10", m.getTarget());
	}
}
