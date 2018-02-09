package org.genericenumtask;

public enum Level {
	HIGH(3),
	LOW(1),
	Medium(2);
	
	private int value;
	
	Level(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
