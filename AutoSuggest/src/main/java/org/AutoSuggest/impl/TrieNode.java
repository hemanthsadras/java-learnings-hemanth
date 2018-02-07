package org.AutoSuggest.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of a node in a Trie Data structure with Map implementation
 * 
 * @author hemant kumar
 *
 */
public class TrieNode {

	/**
	 * contains map with all the letters which current node can form a word with
	 */
	private Map<Character, TrieNode> children;
	
	/**
	 * Represents if the word is ending or not
	 */
	private boolean isEnd;

	public TrieNode() {
		children = new HashMap<>();
		isEnd = false;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

}
