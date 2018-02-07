package org.WikiWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Responsible for parsing CSV files
 * @author hemant kumar
 *
 */
public class CSVFileParser implements FileParser {

	/**
	 * returns List<String> - contains keyword from the CSVFile input
	 */
	@Override
	public List<String> getAllKeywords(Path path) throws IOException {
		String contents =new String(Files.readAllBytes(path));
    	String[] words = contents.split(",");
    	return Arrays.stream(words)
    				 .map(word -> word.trim())
    				 .filter(word -> word.length() > 1)
    				 .collect(Collectors.toList());
  
	}

}
