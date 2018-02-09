package com.lrutask.doublelinkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lrutask.Page;
import com.lrutask.os.PageRepository;

public class LeastRecentlyUsed implements PageReplacementStrategy {

	private Node<Page> start;
	private Node<Page> end;
	private int capacity;
	private int currentCapacity;
	private PageRepository pageRepository;

	public LeastRecentlyUsed() {
		this(5); // default capacity
	}

	public LeastRecentlyUsed(int capacity) {
		this.capacity = capacity;
		this.currentCapacity = 0;
		pageRepository = PageRepository.getInstance();
	}

	public Page getPageById(int pageId) {

		if (start != null && start.getData().getPageId() == pageId) {
			return this.start.getData();
		} else {
			Node<Page> targetNode = getTargetNode(pageId);
			if (targetNode != null) {
				moveNodeToStart(targetNode);
			} else {
				Optional<Page> targetPage = pageRepository.getPageById(pageId);
				if (targetPage.isPresent()) {
					insertAtStart(new Node<Page>(targetPage.get()));
				} else {
					throw new RuntimeException("Page Not Found");
				}
			}
			return this.start.getData();
		}
	}

	public void addPage(Page page) {
		Node<Page> node = new Node<>(page);
		if (isEmpty()) {
			start = node;
			end = node;
			currentCapacity++;
		} else if (isFull()) {
			end = deleteLastNodeAndReturnPreviousLast();
			insertAtStart(node);
		} else {
			insertAtStart(node);
		}

	}

	public void deletePage(int id) {
		Node<Page> current = start;

		while (current != null) {
			if (current.getData().getPageId() == id) {
				Node<Page> previousNode = current.previous;
				if (previousNode != null) {
					previousNode.next = current.next;
					current.next.previous = previousNode;
				} else {
					this.start = current.next;
				}
				currentCapacity--;
				break;
			}
		}
	}

	public List<Page> getAllPages() {
		List<Page> allPages = new ArrayList<>();
		Node<Page> current = start;

		while (current != null) {
			allPages.add(current.getData());
			current = current.next;
		}

		return allPages;
	}

	public int getCapacity() {
		return this.capacity;
	}

	private boolean isEmpty() {
		return start == null;
	}

	private boolean isFull() {
		return this.currentCapacity >= this.capacity;
	}

	private Node<Page> deleteLastNodeAndReturnPreviousLast() {
		Node<Page> previousLast = end.getPrevious();
		previousLast.next = null;
		currentCapacity--;
		return previousLast;
	}

	private void insertAtStart(Node<Page> node) {
		if (isEmpty()) {
			addPage(node.getData());
		} else if (isFull()) {
			end = deleteLastNodeAndReturnPreviousLast();
			insertAtStart(node);
		} else {
			node.next = start;
			start.previous = node;
			start = node;
			currentCapacity++;
		}
	}

	private Node<Page> getTargetNode(int pageId) {
		Node<Page> current = this.start;
		while (current != null) {
			if (current.getData().getPageId() == pageId) {
				return current;
			}
			current = current.next;
		}

		return null;
	}

	private void moveNodeToStart(Node<Page> node) {
		Node<Page> previousNode = node.previous;
		Node<Page> nextNode = node.next;
		if (previousNode != null) {
			previousNode.next = nextNode;
		}
		if (nextNode != null) {
			nextNode.previous = previousNode;
		}
		currentCapacity--;
		insertAtStart(node);
	}

}
