
package com.battleship.game.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.battleship.game.exception.FileIOReadException;

/**
 * @author JATIN MAHAJAN
 *
 */
public final class FileIOUtil {

	private final static Logger logger = Logger.getLogger(FileIOUtil.class);

	private FileIOUtil() {
	}

	public static List<String> readFile(String fileName) {
		try (Stream<String> stream = Files
				.lines(Paths.get(FileIOUtil.class.getClassLoader().getResource(fileName).toURI()))) {
			return stream.collect(Collectors.toList());
		} catch (IOException | URISyntaxException e) {
			logger.error("Unable to read file failed with exception : ", e);
			throw new FileIOReadException("Unable to read the input file" + fileName);
		}
	}

}
