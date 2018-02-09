package com.lrutask.os;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lrutask.Page;

public class PageRepository {
	
	private List<Page> allPages = new ArrayList<>();
	private static PageRepository INSTANCE;
	
	private PageRepository() {
		init();
		
	}
	
	public static PageRepository getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PageRepository();
		}
		
		return INSTANCE;
	}
	
	private void init() {
		allPages.add(new Page(120,"120"));
		allPages.add(new Page(121,"121"));
		allPages.add(new Page(122,"122"));
		allPages.add(new Page(123,"123"));
		allPages.add(new Page(124,"124"));
		allPages.add(new Page(125,"125"));
		allPages.add(new Page(126,"126"));
		allPages.add(new Page(127,"127"));
		allPages.add(new Page(128,"128"));
		allPages.add(new Page(129,"129"));
		allPages.add(new Page(130,"130"));
		allPages.add(new Page(131,"131"));
		allPages.add(new Page(132,"132"));
		allPages.add(new Page(133,"133"));
		allPages.add(new Page(134,"134"));
		allPages.add(new Page(135,"135"));
		allPages.add(new Page(136,"136"));
		allPages.add(new Page(137,"137"));
		allPages.add(new Page(138,"138"));
		allPages.add(new Page(139,"139"));

	}
	
	public Optional<Page> getPageById(int id) {
		Optional<Page> page = allPages.stream()
									  .filter(p -> p.getPageId() == id)
									  .findFirst();
		return page;
									  
	}

}
