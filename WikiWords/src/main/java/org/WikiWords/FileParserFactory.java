package org.WikiWords;

/**
 * It is a factory responsbile for creating FileParser object based on the
 * fileType given
 * 
 * @author hemant kumar
 *
 */
public class FileParserFactory {

	public static FileParser getInstance(String fileType) {

		switch (fileType) {
		case "text":
			return new TextFileParser();
		case "csv":
			return new CSVFileParser();
		default:
			throw new RuntimeException("File Parser not found");
		}
	}
}
