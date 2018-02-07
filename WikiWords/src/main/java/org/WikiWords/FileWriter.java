package org.WikiWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Responsbile for writing contents to a file on local disk
 * @author hemant kumar
 *
 */
public class FileWriter implements Writer {

	private Path destinationPath;
	
	public FileWriter(Path path) {
		this.destinationPath = path;
	}
	@Override
	public void writeTo(String contents, String fileName) throws IOException {
		Files.write(Paths.get(destinationPath.toString(), fileName), contents.getBytes());
	}

}
