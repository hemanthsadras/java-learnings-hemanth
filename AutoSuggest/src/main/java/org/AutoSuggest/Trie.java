package org.AutoSuggest;

import java.util.List;

public interface Trie {
	
	void insert(String word);
	boolean isPresent(String word);
	List<String> prefixSearch(String searchText);
}
