package org.WikiWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Responsible for parsing text files and extracting keywords
 * @author hemant kumar
 *
 */
public class TextFileParser implements FileParser {

	@Override
	public List<String> getAllKeywords(Path path) throws IOException {
		return Files.readAllLines(path);
	}

}
