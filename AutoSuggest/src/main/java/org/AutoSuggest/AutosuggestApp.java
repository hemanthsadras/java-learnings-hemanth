package org.AutoSuggest;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * AutoSuggest APP
 * Given a search Text it outputs all the words starting 
 * with the given search text
 * @author hemant kumar
 *
 */
public class AutosuggestApp 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Loading data into Trie Please wait....");
        Trie trie = Util.loadDataFromFile(AutosuggestApp.class.getResource("Words").getPath());
        System.out.println("Data Loaded");
        
        while(true) {
        	System.out.println("Type text to get prefix suggestions / type !!! to exit");
        	Scanner scanner = new Scanner(System.in);
        	String searchText = scanner.nextLine();
        	if(isGoodByeCommand(searchText)) {
        		break;
        	}
        	else {
        		List<String> suggestions = trie.prefixSearch(searchText);
        		System.out.println("Suggestions are..");
        		suggestions.stream().forEach(System.out::println);
        	}
        	
        }
        
        System.out.println("GoodBye!!!!");
    }

	private static boolean isGoodByeCommand(String searchText) {
		return searchText.equals("!!!");
	}
}
