package org.WikiWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Application which generates a file containing
 * description from wikipedia for each word in the input file
 * provided
 * @author hemant kumar
 *
 */
public class WikiWordsApp
{
    public static void main( String[] args ) throws IOException
    {
    	WikiDescriptionCreator textFileDescriptionCreator = getWikiDescriptionCreator("inputFile.txt", "text");
    	WikiDescriptionCreator csvFileDescriptionCreator = getWikiDescriptionCreator("inputcsvFile.txt", "csv");
    	ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(textFileDescriptionCreator);
        executorService.execute(csvFileDescriptionCreator);
        executorService.shutdown();
   
    }
    
    /**
     * Creates a WikiDescriptionCreator responsible for
     * extracting information from wikipedia and 
     * generating a file with description of the word
     * @param filename - name of the file in which keywords are contained
     * @param fileType - type of the file txt|csv
     * @return WikiDescriptionCreator
     */
    public static WikiDescriptionCreator getWikiDescriptionCreator(String filename, String fileType) {
    	String inputFilePath = WikiWordsApp.class.getResource(filename).getPath();
    	FileParser fileParser	 = FileParserFactory.getInstance(fileType);
    	Writer writer = getFileWriter();
    	return new WikiDescriptionCreator(fileParser, writer, Paths.get(inputFilePath));
    }
    
    /**
     * Returns a filewriter with output folder location
     * @return Writer - returns a FileWrtier
     */
    public static Writer getFileWriter() {
    	Path destinationFolder = Paths.get("/home/hemants/Downloads/WikiFiles");
        return new FileWriter(destinationFolder);
    }
}
