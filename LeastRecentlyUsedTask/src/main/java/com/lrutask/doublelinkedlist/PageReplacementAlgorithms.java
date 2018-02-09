package com.lrutask.doublelinkedlist;

public class PageReplacementAlgorithms {

	public static PageReplacementStrategy getInstance(PageReplacement pageReplacement)
	{
		if(pageReplacement == PageReplacement.LEAST_RECENTLY_USED) {
			return new LeastRecentlyUsed();
		}
		else {
			throw new RuntimeException("Algorithm not found for specified type :" + pageReplacement.name());
		}
	}
}
