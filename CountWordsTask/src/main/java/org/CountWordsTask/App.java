package org.CountWordsTask;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Path filePath = Paths.get("/home/hemants/Documents/countwords.txt");
        WordCounter wordCounter = new WordCounter();
        Map<String,Integer> frequency = wordCounter.getFrequencyCountInFile(filePath);
        
       frequency.forEach((key,value) -> {
    	   System.out.println(key + " -> " + value);
       });
    }
}
