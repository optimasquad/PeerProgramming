package com.battleship.game.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * @author JATIN MAHAJAN
 *
 */
public class FileIOUtilTest {

	@Test
	public void testReadFile() {
		List<String> input = FileIOUtil.readFile("test-input-player1.txt");
		assertEquals(6, input.size());
	}

}
