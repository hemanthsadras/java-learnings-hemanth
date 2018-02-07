package org.AutoSuggest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.AutoSuggest.impl.TrieImpl;

public class Util {
	
	public static Trie loadDataFromFile(String filePath) throws IOException {
		 Trie trie = new TrieImpl();
		 List<String> words = Files.readAllLines(Paths.get(filePath));
		 words.forEach(word -> {
			 trie.insert(word.toLowerCase());
		 });
		 
		 return trie;
	}

}
