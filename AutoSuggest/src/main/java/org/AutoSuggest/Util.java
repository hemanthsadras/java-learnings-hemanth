package org.AutoSuggest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.AutoSuggest.impl.TrieImpl;

/**
 * Util class to maintain common method
 * @author hemant kumar
 *
 */
public class Util {
	
	/**
	 * 
	 * @param filePath - input filepath to be loaded into Trie
	 * @return a Trie with data read from the filePath given
	 * @throws IOException - when filepath is invalid
	 */
	public static Trie loadDataFromFile(String filePath) throws IOException {
		 Trie trie = new TrieImpl();
		 List<String> words = Files.readAllLines(Paths.get(filePath));
		 words.forEach(word -> {
			 trie.insert(word.toLowerCase());
		 });
		 
		 return trie;
	}

}
