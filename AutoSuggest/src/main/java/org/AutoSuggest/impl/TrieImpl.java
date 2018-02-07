package org.AutoSuggest.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.AutoSuggest.Trie;

public class TrieImpl implements Trie {
	
	private TrieNode root;
	
	public TrieImpl() {
		this.root = new TrieNode();
	}

	public void insert(String word) {	
		TrieNode current = root;
		for(char ch : word.toCharArray()) {
			TrieNode node = current.getChildren().get(ch);
			if(node == null) {
				node = new TrieNode();
				current.getChildren().put(ch, node);
			}
			
			current = node;
		}
        current.setEnd(true);
	}

	public boolean isPresent(String word) {
		word = word.toLowerCase();
		TrieNode current = root;
		for(char ch : word.toCharArray()) {
			TrieNode node = current.getChildren().get(ch);
			if(node == null) {
				return false;
			}
			else {
				current = node;
			}
		}
		
		return current.isEnd();
	}

	public List<String> prefixSearch(String searchText) {
		searchText = searchText.toLowerCase();
		TrieNode prefixNode = getPrefixNode(searchText);
		return getSuggestions(prefixNode,searchText, "");
	}
	
	private List<String> getSuggestions(TrieNode prefixRoot, String prefix, String word) {
		List<String> results = new ArrayList<>();
		for(Entry<Character,TrieNode> entry : prefixRoot.getChildren().entrySet()) {
			if(entry.getValue().isEnd()) {
				results.add(prefix + word + entry.getKey());
			}
			List<String> suggestions = getSuggestions(entry.getValue(),prefix,word+entry.getKey());
			results.addAll(suggestions);
		}
		return results;
	}

	private TrieNode getPrefixNode(String searchText) {
		TrieNode current = root;
		for(char ch : searchText.toCharArray()) {
			TrieNode node = current.getChildren().get(ch);
			if(node == null) {
				return current;
			}
			else {
				current = node;
			}
		}
		
		return current;
	}

}
