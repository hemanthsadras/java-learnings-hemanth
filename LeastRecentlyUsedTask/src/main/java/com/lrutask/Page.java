package com.lrutask;

public class Page {

	private int pageId;
	private String pageContents;

	public Page(int pageId, String pageContents) {
		this.pageContents = pageContents;
		this.pageId = pageId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getPageContents() {
		return pageContents;
	}

	public void setPageContents(String pageContents) {
		this.pageContents = pageContents;
	}

}
