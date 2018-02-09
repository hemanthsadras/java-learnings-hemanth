package com.lrutask;

import java.util.List;
import java.util.Scanner;

import com.lrutask.doublelinkedlist.PageReplacement;
import com.lrutask.doublelinkedlist.PageReplacementAlgorithms;
import com.lrutask.doublelinkedlist.PageReplacementStrategy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PageReplacementStrategy pageReplacementStrategy = PageReplacementAlgorithms.getInstance(PageReplacement.LEAST_RECENTLY_USED);
        
        do {
        	Scanner scanner = new Scanner(System.in);
        	System.out.println("Request a page with id's between 120 and 139 or type 0 to exit");
        	int pageId = scanner.nextInt();
        	if(pageId == 0) {
        		break;
        	}
        	else {
        		Page page = pageReplacementStrategy.getPageById(pageId);
        		System.out.println("Requested page has contents --" + page.getPageContents());
        		printAllPages(pageReplacementStrategy.getAllPages());
        	}
        	
        }while(true);
        
        System.out.println("GoodBye!!!!");
    }
    
    private static void printAllPages(List<Page> pages) {
    	System.out.println("All Pages in memory are: ");
    	pages.stream()
    		 .map(page -> page.getPageId())
    		 .forEach(pageId -> System.out.print(pageId + "\t"));
    	System.out.println();
    }
}
