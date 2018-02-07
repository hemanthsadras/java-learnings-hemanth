package org.WikiWords.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Rest Client to interact with Rest APIS
 * @author hemant kumar
 *
 */
public class RestClient {

	private final String baseUrl;

	public RestClient(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * executes HTTP GET Method
	 * @param pathParameter
	 * @return
	 */
	public String get(String pathParameter) {

		String output = "";
		try {

			Client client = Client.create();
			WebResource webResource = client.resource(baseUrl).path(pathParameter);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			output = response.getEntity(String.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return output;
	}

}
