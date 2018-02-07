package org.WikiWords;

import java.io.IOException;
import java.util.List;

/**
 * Abstraction for a Writer, enforces the WriteTo behaviour
 * which writes the given contents with given filename
 * @author hemant kumar
 *
 */
public interface Writer {
	
	/**
	 * 
	 * @param contents - file contents
	 * @param filename - name of the file
	 * @throws IOException - throws IOException if failed to write
	 */
	void writeTo(String contents, String filename) throws IOException;

}
