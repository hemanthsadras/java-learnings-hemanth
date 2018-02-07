package org.WikiWords;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Responsbile for creating a file with wikipedia description
 * for the keywords in the file
 * @author hemant kumar
 *
 */
public class WikiDescriptionCreator implements Runnable {
	
	private FileParser fileParser;
	private Path filePath;
	private Writer writer;
	
	public WikiDescriptionCreator(FileParser fileParser, Writer writer, Path filePath) {
		this.fileParser = fileParser;
		this.filePath = filePath;
		this.writer = writer;
	}

	@Override
	public void run() {	
		try {
			WikiManager wikiManager = new WikiManager();
			List<String> keywords = fileParser.getAllKeywords(filePath);	
			keywords.parallelStream()
					.map(wikiManager)
					.forEach(description -> {
									try {
										writer.writeTo(description, "wiki-"+LocalDateTime.now().toString());
									} catch (IOException e) {
										throw new RuntimeException("writing file failed", e);
									}
							});		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}

