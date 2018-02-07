package org.TraverseCSVTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * App which traverses the given file and generates multile files with fixed amount of lines
 * @author hemant kumar
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get(App.class.getResource("inputFile.txt").getPath()));
        RecursiveAction action = new WriteToFileAction(lines, "/home/hemants/Downloads/outfiles");
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.invoke(action);
        System.out.println("Done");
    }
}
