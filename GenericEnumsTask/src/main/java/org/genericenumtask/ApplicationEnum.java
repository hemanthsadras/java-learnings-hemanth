package org.genericenumtask;

public interface ApplicationEnum<T> {
	
	T getValue();
	
	public static <T> ApplicationEnum<T> getInstance(Class<? extends ApplicationEnum<T>> clazz, T value) {
		for(ApplicationEnum<T> e: clazz.getEnumConstants()){
			if(e.getValue().equals(value)) {
				return e;
			}
				
		}
		
		throw new ApplicationEnumNotFound("Enum not found for specified value " + value);
	}

}
