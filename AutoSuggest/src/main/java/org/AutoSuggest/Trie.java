package org.AutoSuggest;

import java.util.List;

/**
 * Abstraction for Trie Data structure
 * @author hemanth kumar
 *
 */
public interface Trie {
	
	/**
	 * inserts a given word in the trie
	 * @param word
	 */
	void insert(String word);
	
	/**
	 * Checks if the given word contains in 
	 * the trie
	 * @param word
	 * @return true - if given word is present else false
	 */
	boolean isPresent(String word);
	
	/**
	 * Returns List<String> containing all the words
	 * starting with the given parameter
	 * @param searchText
	 * @return
	 */
	List<String> prefixSearch(String searchText);
}
