package org.WikiWords;

import java.util.function.Function;

import org.WikiWords.restclient.RestClient;
import org.WikiWords.util.Util;
import org.json.JSONObject;

/**
 * WikiManager is responsible for communicating with wikipedia
 * @author hemant kumar
 *
 */
public class WikiManager implements Function<String,String> {

	private final String WIKI_URL = "https://en.wikipedia.org/api/rest_v1/page/summary";
	
	/**
	 * Takes keyword from the keyword parameter
	 * and returns the wikipedia description of the word
	 */
	@Override
	public String apply(String keyword) {
		RestClient client = new RestClient(WIKI_URL);
		String output = client.get(Util.getUrlEncodedString(keyword));
		JSONObject jsonObject = new JSONObject(output);
		try {
			return jsonObject.getString("extract");
		}
		catch(Exception e) {
			return "";
		}
		
	}
	
	

}
