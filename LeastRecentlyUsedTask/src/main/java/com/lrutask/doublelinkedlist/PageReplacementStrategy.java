package com.lrutask.doublelinkedlist;

import java.util.List;

import com.lrutask.Page;

public interface PageReplacementStrategy {
	
	Page getPageById(int pageId);
	void addPage(Page page);
	void deletePage(int id);
	List<Page> getAllPages();
	int getCapacity();

}
