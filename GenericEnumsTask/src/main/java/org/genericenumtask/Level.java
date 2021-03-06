package org.genericenumtask;

public enum Level implements ApplicationEnum<String>{
	HIGH("High"),
	LOW("Low"),
	Medium("Medium");
	
	private String value;
	
	Level(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
}
