package org.WikiWords;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * This is an abstraction for FileParser
 * Responsible for parsing the file
 * and extracting the keywords out of it
 * @author hemant kumar
 *
 */
public interface FileParser {
	
	/**
	 * it takes Path as an argument for inputFile
	 * Parses the file and returns a list of string
	 * containing all the keywords in the give file
	 * @param path - Path for input file
	 * @return List<String> - containing keywords in the file
	 * @throws IOException throws IOException if the input Path
	 * provided is invalid
	 */
	List<String> getAllKeywords(Path path) throws IOException;

}
