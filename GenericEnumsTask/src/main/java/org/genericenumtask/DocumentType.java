package org.genericenumtask;

public enum DocumentType  implements ApplicationEnum<String>{

	TEXT("text"),
	CSV("csv"),
	JSON("json");
	
	private String value;
	
	DocumentType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
}
